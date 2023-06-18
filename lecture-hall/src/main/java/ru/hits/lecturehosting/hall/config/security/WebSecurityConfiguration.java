package ru.hits.lecturehosting.hall.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.client.RestTemplate;
import ru.hits.lecturehosting.hall.config.oauth2.OAuth2AuthenticationFailureHandler;
import ru.hits.lecturehosting.hall.config.oauth2.OAuth2AuthenticationSuccessHandler;
import ru.hits.lecturehosting.hall.config.oauth2.fixed.FixedOAuth2UserService;
import ru.hits.lecturehosting.hall.config.oauth2.fixed.FixedTokenResponseConverter;
import ru.hits.lecturehosting.hall.service.UserService;

import java.util.Arrays;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityWebFilterChain(
            HttpSecurity http,
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthenticationSuccessHandler successHandler,
            OAuth2AuthenticationFailureHandler failureHandler
    ) throws Exception {
        return http
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(new HttpStatusSuccessEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(
                                "/swagger",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .tokenEndpoint(tokenEndpoint -> tokenEndpoint
                                .accessTokenResponseClient(accessTokenResponseClient())
                        )
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                .userService(new FixedOAuth2UserService())
                        )
                        .successHandler(successHandler)
                        .failureHandler(failureHandler)
                )
                .build();
    }

    @Bean
    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient =
                new DefaultAuthorizationCodeTokenResponseClient();
        OAuth2AccessTokenResponseHttpMessageConverter tokenResponseHttpMessageConverter =
                new OAuth2AccessTokenResponseHttpMessageConverter();
        tokenResponseHttpMessageConverter.setAccessTokenResponseConverter(new FixedTokenResponseConverter());
        RestTemplate restTemplate = new RestTemplate(Arrays.asList(
                new FormHttpMessageConverter(), tokenResponseHttpMessageConverter));
        restTemplate.setErrorHandler(new OAuth2ErrorResponseErrorHandler());
        accessTokenResponseClient.setRestOperations(restTemplate);
        return accessTokenResponseClient;
    }

    @Bean
    public OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler(
            UserService userService
    ) {
        return new OAuth2AuthenticationSuccessHandler("http://localhost", userService);
    }

    @Bean
    public OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler() {
        return new OAuth2AuthenticationFailureHandler("http://localhost/failure");
    }
}
