package ru.hits.lecturehosting.hall.service;

import com.vk.api.sdk.objects.video.VideoFull;
import com.vk.api.sdk.objects.video.responses.GetResponse;
import com.vk.api.sdk.objects.video.responses.SaveResponse;

import java.util.Optional;

public interface VkApiService {

    SaveResponse createVideo(String title, String description);

    Optional<VideoFull> getVideo(int vkVideoId);

}
