package ru.hits.lecturehosting.hall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integration.frontend")
@Data
public class FrontendProperties {

    private final String successUrl;
    private final String failedUrl;

}
