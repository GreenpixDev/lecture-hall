package ru.hits.lecturehosting.video.service.impl;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.video.responses.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hits.lecturehosting.video.entity.UploadedVideo;
import ru.hits.lecturehosting.video.repository.VideoRepository;
import ru.hits.lecturehosting.video.service.UploadService;
import ru.hits.lecturehosting.video.service.VideoService;
import ru.hits.lecturehosting.video.settings.VkSettings;
import ru.hits.lecturehosting.video.util.TemporaryFile;

import java.io.IOException;
import java.net.URI;

@RequiredArgsConstructor
@Service
public class VideoServiceImpl implements VideoService {

    private final VkApiClient client;
    private final VkSettings settings;
    private final UploadService uploadService;
    private final VideoRepository videoRepository;

    public URI createVideo(String title) {
        SaveResponse saveResponse;
        try {
            saveResponse = client.videos().save(getUserActor())
                    .name(title)
                    .groupId(221066297)
                    .execute();
        }
        catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }

        UploadedVideo video = new UploadedVideo();
        video.setTitle(title);
        video.setVkId(saveResponse.getVideoId());
        videoRepository.save(video);

        return saveResponse.getUploadUrl();
    }

    @Override
    public void upload(String name, MultipartFile videoFile) {


        try (TemporaryFile temporaryFile = new TemporaryFile(getExtension(videoFile))) {
            videoFile.transferTo(temporaryFile.getPath());

            URI uri = client.videos().save(getUserActor())
                    .name(name)
                    .groupId(221066297)
                    .execute()
                    .getUploadUrl();


        }
        catch (ApiException | ClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getExtension(MultipartFile file) {
        return "mp4"; // TODO
    }

    private UserActor getUserActor() {
        return new UserActor(0, settings.getAccessToken());
    }

}
