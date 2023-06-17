package ru.hits.lecturehosting.video.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vk")
@Data
public class VkSettings {

    private final String accessToken;

}
