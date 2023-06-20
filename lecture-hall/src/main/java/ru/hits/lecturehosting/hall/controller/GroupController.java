package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.special.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

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
            @AuthenticationPrincipal UserPrincipal user,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchGroupDto dto
    ) {
        return groupService.getGroups(user, page - 1, count, dto);
    }

    @Operation(summary = "Создание группы")
    @PostMapping("new")
    public void createGroup(
            @AuthenticationPrincipal UserPrincipal user,
            @RequestBody CreationGroupDto dto
    ) {
        groupService.createGroup(user, dto);
    }

    @Operation(summary = "Обновление группы")
    @PutMapping("{groupId}")
    public void updateGroup(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @RequestBody UpdateGroupDto dto
    ) {
        groupService.updateGroup(user, groupId, dto);
    }

    @Operation(summary = "Удаление группы")
    @DeleteMapping("{groupId}")
    public void deleteGroup(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId
    ) {
        groupService.deleteGroup(user, groupId);
    }

    @Tag(name = "invitation")
    @Tag(name = "user")
    @Operation(summary = "Присоединение к группе по коду приглашения")
    @PostMapping("entrance")
    public void joinToGroup(
            @AuthenticationPrincipal UserPrincipal user,
            @RequestBody JoiningGroupDto dto
    ) {
        groupService.joinToGroup(user, dto);
    }

    @Tag(name = "user")
    @Operation(summary = "Выйти из группы")
    @PostMapping("{groupId}/exit")
    public void quitFromGroup(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId
    ) {
        groupService.quitFromGroup(user, groupId);
    }
}
