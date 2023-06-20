package ru.hits.lecturehosting.hall.config.oauth2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.hits.lecturehosting.hall.config.jwt.JwtManager;
import ru.hits.lecturehosting.hall.config.jwt.JwtUser;
import ru.hits.lecturehosting.hall.util.OAuth2VkUser;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtUrlSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler {

    private final String defaultUrl;
    private final JwtManager jwtManager;

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        return defaultUrl + "?jwt=" + jwtManager.generateToken(new JwtUser(
                ((OAuth2VkUser) token.getPrincipal()).getId()
        ));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handle(request, response, authentication);
    }
}
