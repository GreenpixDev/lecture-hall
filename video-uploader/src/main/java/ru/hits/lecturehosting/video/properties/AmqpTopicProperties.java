package ru.hits.lecturehosting.video.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "amqp.topic")
@Data
public class AmqpTopicProperties {

    private final String video;

}
