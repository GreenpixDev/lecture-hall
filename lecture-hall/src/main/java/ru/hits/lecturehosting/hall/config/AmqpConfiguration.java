package ru.hits.lecturehosting.hall.config;

import com.vk.api.sdk.objects.responses.VideoUploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hits.lecturehosting.hall.dto.amqp.AmqpVideoUpdateDto;
import ru.hits.lecturehosting.hall.service.VideoService;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class AmqpConfiguration {

    private final VideoService videoService;

    @Bean
    public Consumer<VideoUploadResponse> updateVideoStatusConsumer() {
        return videoService::updateVideoStatus;
    }

}
