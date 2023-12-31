package ru.hits.lecturehosting.hall.config.oauth2;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;

import java.util.HashMap;
import java.util.Map;

// https://sysout.ru/single-sign-on-s-postavshhikom-vk/
public class FixedTokenResponseConverter implements Converter<Map<String, Object>, OAuth2AccessTokenResponse> {

    @Override
    public OAuth2AccessTokenResponse convert(Map<String, Object> tokenResponseParameters) {
        Object accessToken = tokenResponseParameters.get(OAuth2ParameterNames.ACCESS_TOKEN);
        OAuth2AccessToken.TokenType accessTokenType = OAuth2AccessToken.TokenType.BEARER;
        Map<String, Object> additionalParameters = new HashMap<>(tokenResponseParameters);
        return OAuth2AccessTokenResponse.withToken(accessToken.toString())
                .tokenType(accessTokenType)
                .additionalParameters(additionalParameters)
                .build();
    }
}