package ru.hits.lecturehosting.hall.config.jwt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hits.lecturehosting.hall.config.jwt.impl.JwtManagerImpl;
import ru.hits.lecturehosting.hall.settings.SecurityJwtSettings;

import java.time.Clock;
import java.util.Optional;

@Configuration
public class JwtConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JwtManager jwtManager(
            SecurityJwtSettings settings
    ) {
        return new JwtManagerImpl(settings.getSecret(), settings.getExpirationMinutes());
    }

    @Bean
    @ConditionalOnMissingBean
    public JwtAuthenticationConverter jwtAuthenticationConverter(JwtManager manager) {
        return new JwtAuthenticationConverter(manager);
    }

}

