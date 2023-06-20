package ru.hits.lecturehosting.hall.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "security.jwt")
public class SecurityJwtSettings {

    private final String secret;

    private final long expirationMinutes;

}
