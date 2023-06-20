package ru.hits.lecturehosting.hall.service.impl;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.groups.responses.CreateResponse;
import com.vk.api.sdk.objects.video.VideoFull;
import com.vk.api.sdk.objects.video.responses.GetResponse;
import com.vk.api.sdk.objects.video.responses.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.properties.VkProperties;
import ru.hits.lecturehosting.hall.service.VkApiService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VkApiServiceImpl implements VkApiService {

    private final VkApiClient client;
    private final VkProperties properties;

    @Override
    public SaveResponse createVideo(String title, String description) {
        SaveResponse saveResponse;
        try {
            saveResponse = client.videos().save(getSuperUser())
                    .name(title)
                    .description(description)
                    .groupId(properties.getHosting().getGroupId())
                    .execute();
        }
        catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
        return saveResponse;
    }

    @Override
    public Optional<VideoFull> getVideo(int vkVideoId) {
        int vkOwnerId = -1 * properties.getHosting().getGroupId();

        GetResponse getResponse;
        try {
            getResponse = client.videos().get(getSuperUser())
                    .ownerId(vkOwnerId)
                    .videos(vkOwnerId + "_" + vkVideoId)
                    .count(1)
                    .execute();
        }
        catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }

        if (getResponse.getItems().isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(getResponse.getItems().get(0));
    }

    private UserActor getSuperUser() {
        return new UserActor(
                properties.getSuperUser().getUserId(),
                properties.getSuperUser().getAccessToken()
        );
    }
}
