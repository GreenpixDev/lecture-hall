package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import ru.hits.lecturehosting.hall.SecurityConst;
import ru.hits.lecturehosting.hall.config.jwt.JwtUser;
import ru.hits.lecturehosting.hall.dto.CreatedInvitationDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.service.InvitationService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Tag(name = "invitation")
@RestController
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @Tag(name = "group")
    @Operation(summary = "Список приглашений в группе")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @GetMapping("groups/{groupId}/invitations")
    public PageDto<InvitationDto> getGroupInvitations(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        return invitationService.getGroupInvitations(user, groupId, page - 1, count);
    }


    @Operation(summary = "Информация о приглашении")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @GetMapping("invitations/{invitationId}")
    public InvitationDto getGroupInvitations(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID invitationId
    ) {
        return invitationService.getInvitation(user, invitationId);
    }

    @Tag(name = "group")
    @Operation(summary = "Создание приглашения в группе")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PostMapping("groups/{groupId}/invitations/new")
    public CreatedInvitationDto createInvitation(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID groupId,
            @RequestBody CreationInvitationDto dto
    ) {
        return invitationService.createGroupInvitation(user, groupId, dto);
    }

    @Operation(summary = "Обновление приглашения")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PutMapping("invitations/{invitationId}")
    public void updateInvitation(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID invitationId,
            @RequestBody UpdateInvitationDto dto
    ) {
        invitationService.updateInvitation(user, invitationId, dto);
    }

    @Operation(summary = "Удаление приглашения")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @DeleteMapping("invitations/{invitationId}")
    public void deleteInvitation(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID invitationId
    ) {
        invitationService.deleteInvitation(user, invitationId);
    }
}
