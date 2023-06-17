package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.GroupDto;

import java.util.List;

public interface GroupService {

    List<GroupDto> getGroups(OAuth2User user);

}
