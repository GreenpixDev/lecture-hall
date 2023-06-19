package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.entity.User;

public interface UserService {

    User saveUserIfNotExists(OAuth2User oAuth2User);

}
