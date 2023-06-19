package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.CreatedInvitationDto;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

public interface InvitationService {

    PageDto<InvitationDto> getGroupInvitations(UserPrincipal principal, UUID groupId, int page, int size);

    CreatedInvitationDto createGroupInvitation(UserPrincipal principal, UUID groupId, CreationInvitationDto dto);

    void updateInvitation(UserPrincipal principal, UUID invitationId, UpdateInvitationDto dto);

    void deleteInvitation(UserPrincipal principal, UUID invitationId);

}
