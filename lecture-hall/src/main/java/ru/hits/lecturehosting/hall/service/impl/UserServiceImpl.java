package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.entity.User;
import ru.hits.lecturehosting.hall.repository.UserRepository;
import ru.hits.lecturehosting.hall.service.UserService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void saveUserIfNotExists(OAuth2AuthenticationToken token) {
        Integer vkId = token.getPrincipal().getAttribute("id");

        if (!userRepository.existsByVkId(vkId)) {
            User user = new User();
            user.setVkId(vkId);
            user.setRegistrationDateTime(LocalDateTime.now());
            userRepository.save(user);
        }
    }
}