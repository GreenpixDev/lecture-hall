package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    PageDto<GroupDto> getGroups(UserPrincipal principal, int page, int size, SearchGroupDto dto);

    void createGroup(UserPrincipal principal, CreationGroupDto dto);

    void updateGroup(UserPrincipal principal, UUID groupId, UpdateGroupDto dto);

    void deleteGroup(UserPrincipal principal, UUID groupId);

    void joinToGroup(UserPrincipal principal, JoiningGroupDto dto);

    void quitFromGroup(UserPrincipal principal, UUID groupId);

}
