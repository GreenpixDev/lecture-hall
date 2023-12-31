package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import ru.hits.lecturehosting.hall.SecurityConst;
import ru.hits.lecturehosting.hall.config.jwt.JwtUser;
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
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PostMapping("groups/{groupId}/subjects/search")
    public PageDto<SubjectDto> getSubjects(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchSubjectDto dto
    ) {
        return subjectService.getGroupSubjects(user, groupId, page - 1, count, dto);
    }

    @Operation(summary = "Информация о предмете")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PostMapping("subjects/{subjectId}")
    public SubjectDto getSubjects(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID subjectId
    ) {
        return subjectService.getSubject(user, subjectId);
    }

    @Tag(name = "group")
    @Operation(summary = "Создание предмета в группе")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PostMapping("groups/{groupId}/subjects/new")
    public void createSubject(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID groupId,
            @RequestBody CreationSubjectDto dto
    ) {
        subjectService.createGroupSubject(user, groupId, dto);
    }

    @Operation(summary = "Обновление предмета")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PutMapping("subjects/{subjectId}")
    public void updateSubject(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID subjectId,
            @RequestBody UpdateSubjectDto dto
    ) {
        subjectService.updateSubject(user, subjectId, dto);
    }

    @Operation(summary = "Удаление предмета")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @DeleteMapping("subjects/{subjectId}")
    public void deleteSubject(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID subjectId
    ) {
        subjectService.deleteSubject(user, subjectId);
    }

}
