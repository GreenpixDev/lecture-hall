package ru.hits.lecturehosting.hall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vk")
@Data
public class VkProperties {

    private final SuperUser superUser;

    private final Hosting hosting;

    @Data
    public static class SuperUser {

        private final int userId;

        private final String accessToken;

    }

    @Data
    public static class Hosting {

        private final int groupId;

    }

}
