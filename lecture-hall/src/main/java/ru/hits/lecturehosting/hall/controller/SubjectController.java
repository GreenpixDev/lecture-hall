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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.search.SearchSubjectDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateSubjectDto;
import ru.hits.lecturehosting.hall.service.SubjectService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Tag(name = "subject")
@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @Tag(name = "group")
    @Operation(summary = "Поиск предметов в группе")
    @PostMapping("groups/{groupId}/subjects/search")
    public PageDto<SubjectDto> getSubjects(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchSubjectDto dto
    ) {
        return subjectService.getGroupSubjects(user, groupId,  - 1, count, dto);
    }

    @Tag(name = "group")
    @Operation(summary = "Создание предмета в группе")
    @PostMapping("groups/{groupId}/subjects/new")
    public void createSubject(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @RequestBody CreationSubjectDto dto
    ) {
        subjectService.createGroupSubject(user, groupId, dto);
    }

    @Operation(summary = "Обновление предмета")
    @PutMapping("subjects/{subjectId}")
    public void updateSubject(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID subjectId,
            @RequestBody UpdateSubjectDto dto
    ) {
        subjectService.updateSubject(user, subjectId, dto);
    }

    @Operation(summary = "Удаление предмета")
    @DeleteMapping("subjects/{subjectId}")
    public void deleteSubject(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID subjectId
    ) {
        subjectService.deleteSubject(user, subjectId);
    }

}
