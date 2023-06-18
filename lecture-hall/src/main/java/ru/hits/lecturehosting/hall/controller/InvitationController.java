package ru.hits.lecturehosting.hall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.service.GroupService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InvitationController {

    @GetMapping("groups/{groupId}/invitations")
    public PageDto<InvitationDto> getGroupInvitations(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PostMapping("groups/{groupId}/invitations")
    public void createInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @DeleteMapping("groups/{groupId}/invitations/{invitationId}")
    public void deleteInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @PathVariable UUID invitationId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }
}
