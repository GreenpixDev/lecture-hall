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
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.service.GroupService;

import java.util.UUID;

@Tag(name = "group")
@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @Operation(summary = "Поиск групп")
    @PostMapping("search")
    public PageDto<GroupDto> getGroups(
            @AuthenticationPrincipal OAuth2User user,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchGroupDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Создание группы")
    @PostMapping("new")
    public void createGroup(
            @AuthenticationPrincipal OAuth2User user,
            @RequestBody CreationGroupDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Обновление группы")
    @PutMapping("{groupId}")
    public void updateGroup(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId,
            @RequestBody UpdateGroupDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Удаление группы")
    @DeleteMapping("{groupId}")
    public void deleteGroup(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Tag(name = "invitation")
    @Tag(name = "user")
    @Operation(summary = "Присоединение к группе по коду приглашения")
    @PostMapping("entrance")
    public void joinToGroup(
            @AuthenticationPrincipal OAuth2User user,
            @RequestBody JoiningGroupDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Tag(name = "user")
    @Operation(summary = "Выйти из группы")
    @PostMapping("{groupId}/exit")
    public void quitFromGroup(
            @AuthenticationPrincipal OAuth2User user,
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }
}
