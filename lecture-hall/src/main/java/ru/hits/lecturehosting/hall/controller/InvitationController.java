package ru.hits.lecturehosting.hall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.CreatedInvitationDto;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.service.GroupService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InvitationController {

    @GetMapping("groups/{groupId}/invitations")
    public PageDto<InvitationDto> getGroupInvitations(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PostMapping("groups/{groupId}/invitations")
    public CreatedInvitationDto createInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestBody CreationInvitationDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PutMapping("groups/{groupId}/invitations")
    public void updateInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestBody UpdateInvitationDto dto
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
