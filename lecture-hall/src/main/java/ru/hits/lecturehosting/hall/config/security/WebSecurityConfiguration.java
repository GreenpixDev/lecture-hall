package ru.hits.lecturehosting.hall.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.web.client.RestTemplate;
import ru.hits.lecturehosting.hall.config.jwt.JwtAuthenticationConverter;
import ru.hits.lecturehosting.hall.config.jwt.JwtAuthenticationFilter;
import ru.hits.lecturehosting.hall.config.jwt.JwtManager;
import ru.hits.lecturehosting.hall.config.oauth2.FixedOAuth2UserService;
import ru.hits.lecturehosting.hall.config.oauth2.FixedTokenResponseConverter;
import ru.hits.lecturehosting.hall.config.oauth2.JwtUrlSuccessHandler;
import ru.hits.lecturehosting.hall.properties.FrontendProperties;
import ru.hits.lecturehosting.hall.service.UserService;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfiguration {

    private final FrontendProperties frontendProperties;

    @Bean
    public SecurityFilterChain securityWebFilterChain(
            HttpSecurity http,
            ClientRegistrationRepository clientRegistrationRepository,
            JwtAuthenticationConverter jwtConverter,
            UserService userService,
            JwtManager jwtManager
    ) throws Exception {
        return http
                .sessionManagement(AbstractHttpConfigurer::disable)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(new HttpStatusSuccessEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(
                                "/ping",
                                "/swagger",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .cors(AbstractHttpConfigurer::disable)
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .disable() // TODO убрать
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .tokenEndpoint(tokenEndpoint -> tokenEndpoint
                                .accessTokenResponseClient(accessTokenResponseClient())
                        )
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                .userService(new FixedOAuth2UserService(userService))
                        )
                        .successHandler(new JwtUrlSuccessHandler(frontendProperties.getSuccessUrl(), jwtManager))
                        .failureUrl(frontendProperties.getFailedUrl())
                )
                .addFilterAfter(new JwtAuthenticationFilter(jwtConverter), UsernamePasswordAuthenticationFilter.class)
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

}
