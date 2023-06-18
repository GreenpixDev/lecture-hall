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
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.service.GroupService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public PageDto<GroupDto> getGroups(
            @AuthenticationPrincipal OAuth2User user
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PostMapping
    public void createGroup(
            @AuthenticationPrincipal OAuth2User user
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PutMapping("{groupId}")
    public void updateGroup(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @DeleteMapping("{groupId}")
    public void deleteGroup(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @GetMapping("{groupId}/members")
    public PageDto<MemberDto> getGroupMembers(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PostMapping("joining")
    public void joinToGroup(
            @AuthenticationPrincipal OAuth2User user,
            @RequestBody JoiningGroupDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }
}
