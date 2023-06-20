package ru.hits.lecturehosting.hall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integration.hosting")
@Data
public class HostingProperties {

    private final String url;

    private final String accessToken;

}
