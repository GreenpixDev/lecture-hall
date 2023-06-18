package ru.hits.lecturehosting.hall.config.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.Assert;

public class HttpStatusSuccessEntryPoint implements AuthenticationEntryPoint {

    private final HttpStatus httpStatus;

    /**
     * Creates a new instance.
     * @param httpStatus the HttpStatus to set
     */
    public HttpStatusSuccessEntryPoint(HttpStatus httpStatus) {
        Assert.notNull(httpStatus, "httpStatus cannot be null");
        this.httpStatus = httpStatus;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) {
        if (response.getStatus() == HttpStatus.OK.value()) {
            response.setStatus(httpStatus.value());
        }
    }

}
