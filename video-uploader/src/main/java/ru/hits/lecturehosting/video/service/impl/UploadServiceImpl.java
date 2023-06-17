package ru.hits.lecturehosting.video.service.impl;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.video.service.UploadService;

import java.io.File;
import java.net.URI;

@RequiredArgsConstructor
@Service
public class UploadServiceImpl implements UploadService {

    private final VkApiClient client;

    @Async
    @Override
    public void uploadVideo(URI uploadUri, File videoFile) {
        try {
            client.upload().video(uploadUri.toString(), videoFile)
                    .execute();
        }
        catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
    }
}
