package ru.hits.lecturehosting.hall.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.log.LogMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Некоторый код позаимствован с {@link org.springframework.security.web.authentication.www.BasicAuthenticationFilter}
 */
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtAuthenticationConverter authenticationConverter;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain chain)
            throws ServletException, IOException {

        try {
            Authentication authRequest = authenticationConverter.convert(request);

            if (authRequest == null) {
                logger.trace("Did not process authentication request since failed to find "
                        + "jwt token in Bearer Authorization header");
                SecurityContextHolder.clearContext();
                chain.doFilter(request, response);
                return;
            }

            String username = authRequest.getName();
            logger.trace(LogMessage.format("Found username '%s' in Bearer Authorization header", username));

            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authRequest);
            SecurityContextHolder.setContext(context);
        }
        catch (AuthenticationException ex) {
            SecurityContextHolder.clearContext();
            logger.debug("Failed to process authentication request", ex);
        }

        chain.doFilter(request, response);
    }
}
