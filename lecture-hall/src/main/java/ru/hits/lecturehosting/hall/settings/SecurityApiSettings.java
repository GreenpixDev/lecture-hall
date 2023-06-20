package ru.hits.lecturehosting.hall.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@ConfigurationProperties(prefix = "security.api")
public class SecurityApiSettings {


    private final String key;

}
