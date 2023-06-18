package ru.hits.lecturehosting.hall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.UserDto;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("me")
    public UserDto getAboutMe(
            @AuthenticationPrincipal OAuth2User user
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

}
