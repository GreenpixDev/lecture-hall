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
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.search.SearchMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.service.GroupService;

import java.util.UUID;

@RestController
@RequestMapping("groups/{groupId}/members")
@RequiredArgsConstructor
public class MemberController {

    @PostMapping("search")
    public PageDto<MemberDto> getGroupMembers(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchMemberDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PutMapping("{userId}")
    public void updateGroupMembers(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @PathVariable UUID userId,
            @RequestBody UpdateMemberDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @DeleteMapping("{userId}")
    public void kickGroupMembers(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @PathVariable UUID userId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }
}
