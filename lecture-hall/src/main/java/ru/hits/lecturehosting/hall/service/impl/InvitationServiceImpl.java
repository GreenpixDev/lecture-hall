package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.CreatedInvitationDto;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Invitation;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.exception.GroupNotFoundException;
import ru.hits.lecturehosting.hall.exception.InvitationNotFoundException;
import ru.hits.lecturehosting.hall.mapper.InvitationMapper;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.InvitationRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.InvitationService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepository invitationRepository;

    private final PageMapper pageMapper;
    private final InvitationMapper invitationMapper;

    private final GroupPermissionService groupPermissionService;
    private final GroupRepository groupRepository;

    @Override
    public PageDto<InvitationDto> getGroupInvitations(UserPrincipal principal, UUID groupId, int page, int size) {
        groupPermissionService.checkAdminPermission(principal, groupId);
        return pageMapper.toDto(invitationRepository.searchAll(
                groupId,
                PageRequest.of(page, size)
        ).map(invitationMapper::toDto));
    }

    @Transactional
    @Override
    public CreatedInvitationDto createGroupInvitation(UserPrincipal principal, UUID groupId, CreationInvitationDto dto) {
        groupPermissionService.checkAdminPermission(principal, groupId);

        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        Invitation invitation = invitationMapper.toEntity(dto);
        invitation.setCode(UUID.randomUUID().toString().replace("-", ""));
        invitation = invitationRepository.save(invitation);

        return new CreatedInvitationDto(invitation.getCode());
    }

    @Transactional
    @Override
    public void updateInvitation(UserPrincipal principal, UUID invitationId, UpdateInvitationDto dto) {
        Invitation invitation = invitationRepository.findById(invitationId)
                .orElseThrow(InvitationNotFoundException::new);

        groupPermissionService.checkAdminPermission(principal, invitation.getGroup());

        invitationRepository.save(invitationMapper.partialUpdate(dto, invitation));
    }

    @Transactional
    @Override
    public void deleteInvitation(UserPrincipal principal, UUID invitationId) {
        Invitation invitation = invitationRepository.findById(invitationId)
                .orElseThrow(InvitationNotFoundException::new);

        groupPermissionService.checkAdminPermission(principal, invitation.getGroup());

        invitationRepository.delete(invitation);
    }
}
