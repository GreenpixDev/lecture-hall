package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.CreatedInvitationDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.service.InvitationService;

import java.util.UUID;

@Tag(name = "invitation")
@RestController
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @Tag(name = "group")
    @Operation(summary = "Список приглашений в группе")
    @GetMapping("groups/{groupId}/invitations")
    public PageDto<InvitationDto> getGroupInvitations(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Tag(name = "group")
    @Operation(summary = "Создание приглашения в группе")
    @PostMapping("groups/{groupId}/invitations/new")
    public CreatedInvitationDto createInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestBody CreationInvitationDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Обновление приглашения")
    @PutMapping("invitations/{invitationId}")
    public void updateInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID invitationId,
            @RequestBody UpdateInvitationDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Удаление приглашения")
    @DeleteMapping("invitations/{invitationId}")
    public void deleteInvitation(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @PathVariable UUID invitationId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }
}
