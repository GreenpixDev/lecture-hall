package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.GroupDto;

import java.util.List;

public interface UserService {

    void saveUserIfNotExists(OAuth2AuthenticationToken token);

}
