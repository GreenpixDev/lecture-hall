package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.UserDto;
import ru.hits.lecturehosting.hall.entity.User;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

public interface UserService {

    User saveUserIfNotExists(OAuth2User oAuth2User);

    UserDto getUser(UserPrincipal principal);

}
