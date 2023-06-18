package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface UserService {

    void saveUserIfNotExists(OAuth2AuthenticationToken token);

}
