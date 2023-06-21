package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.UserDto;
import ru.hits.lecturehosting.hall.entity.User;
import ru.hits.lecturehosting.hall.exception.UnauthorizedException;
import ru.hits.lecturehosting.hall.mapper.UserMapper;
import ru.hits.lecturehosting.hall.repository.UserRepository;
import ru.hits.lecturehosting.hall.service.UserService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    @Override
    public User saveUserIfNotExists(OAuth2User oAuth2User) {
        Integer vkId = oAuth2User.getAttribute("id");
        String firstName = oAuth2User.getAttribute("first_name");
        String lastName = oAuth2User.getAttribute("last_name");
        String name = lastName + " " + firstName;

        User user = userRepository.findByVkId(vkId).orElse(null);
        User updatedUser = User.builder()
                .vkId(vkId)
                .name(name)
                .build();
        if (user != null) {
            updatedUser.setId(user.getId());
        }
        return userRepository.save(updatedUser);
    }

    @Override
    public UserDto getUser(UserPrincipal principal) {
        User user = userRepository.findById(principal.getId())
                .orElseThrow(UnauthorizedException::new);
        return userMapper.toDto(user);
    }

}
