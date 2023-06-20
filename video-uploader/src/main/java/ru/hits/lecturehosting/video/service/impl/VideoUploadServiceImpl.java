package ru.hits.lecturehosting.video.service.impl;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.responses.VideoUploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.hits.lecturehosting.video.entity.VideoUpload;
import ru.hits.lecturehosting.video.exception.VideoUploadNotFoundException;
import ru.hits.lecturehosting.video.properties.AmqpTopicProperties;
import ru.hits.lecturehosting.video.repository.VideoUploadRepository;
import ru.hits.lecturehosting.video.service.VideoUploadService;
import ru.hits.lecturehosting.video.util.TemporaryFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class VideoUploadServiceImpl implements VideoUploadService {

    private final VkApiClient client;
    private final VideoUploadRepository videoUploadRepository;

    private final AmqpTopicProperties amqpTopicProperties;
    private final StreamBridge streamBridge;

    @Override
    public UUID createUpload(String url) {
        return videoUploadRepository.save(VideoUpload.builder()
                .vkUploadUrl(url)
                .build()
        ).getId();
    }

    @Transactional
    @Override
    public VideoUpload lockUpload(UUID uploadId) {
        VideoUpload upload = videoUploadRepository.findById(uploadId)
                .filter(e -> !e.isLocked())
                .orElseThrow(VideoUploadNotFoundException::new);
        upload.setLocked(true);
        return videoUploadRepository.save(upload);
    }

    @Override
    public void uploadFile(VideoUpload upload, MultipartFile videoFile) {
        try (TemporaryFile temporaryFile = new TemporaryFile(getExtension(videoFile))) {
            videoFile.transferTo(temporaryFile.getPath());

            VideoUploadResponse response = client.upload()
                    .video(upload.getVkUploadUrl(), temporaryFile.getFile())
                    .execute();
            upload.setUploaded(true);

            streamBridge.send(amqpTopicProperties.getVideo(), response);
        }
        catch (ApiException | ClientException | IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            upload.setLocked(false);
            videoUploadRepository.save(upload);
        }
    }

    private String getExtension(MultipartFile file) {
        return "mp4"; // TODO
    }

}
