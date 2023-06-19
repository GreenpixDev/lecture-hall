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
        return userRepository.findByVkId(vkId).orElseGet(() -> createUser(vkId));
    }

    @Override
    public UserDto getUser(UserPrincipal principal) {
        User user = userRepository.findById(principal.getId())
                .orElseThrow(UnauthorizedException::new);
        return userMapper.toDto(user);
    }

    private User createUser(Integer vkId) {
        User user = new User();
        user.setVkId(vkId);
        user.setRegistrationDateTime(LocalDateTime.now());
        return userRepository.save(user);
    }
}
