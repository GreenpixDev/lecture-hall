package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.CreatedInvitationDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.service.InvitationService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {
    @Override
    public PageDto<InvitationDto> getGroupInvitations(UserPrincipal principal, UUID groupId, int page, int size) {
        return null;
    }

    @Override
    public CreatedInvitationDto createGroupInvitation(UserPrincipal principal, UUID groupId, CreationInvitationDto dto) {
        return null;
    }

    @Override
    public void updateInvitation(UserPrincipal principal, UUID invitationId, UpdateInvitationDto dto) {

    }

    @Override
    public void deleteInvitation(UserPrincipal principal, UUID invitationId) {

    }
}
