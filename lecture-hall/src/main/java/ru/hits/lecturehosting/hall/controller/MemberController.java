package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.search.SearchMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.service.MemberService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Tag(name = "group")
@Tag(name = "member")
@RestController
@RequestMapping("groups/{groupId}/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "Список участников в группе")
    @PostMapping("search")
    public PageDto<MemberDto> getGroupMembers(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchMemberDto dto
    ) {
        return memberService.getGroupMembers(user, groupId, page - 1, count, dto);
    }

    @Operation(summary = "Обновить участника в группе")
    @PutMapping("{userId}")
    public void updateGroupMembers(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @PathVariable UUID userId,
            @RequestBody UpdateMemberDto dto
    ) {
        memberService.updateGroupMember(user, groupId, userId, dto);
    }

    @Operation(summary = "Кикнуть участника из группы")
    @DeleteMapping("{userId}")
    public void kickGroupMembers(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @PathVariable UUID userId
    ) {
        memberService.kickGroupMember(user, groupId, userId);
    }
}
