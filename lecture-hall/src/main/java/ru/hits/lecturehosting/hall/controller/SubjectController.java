package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
import ru.hits.lecturehosting.hall.service.SubjectService;

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
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchSubjectDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Tag(name = "group")
    @Operation(summary = "Создание предмета в группе")
    @PostMapping("groups/{groupId}/subjects/new")
    public void createSubject(
            @PathVariable UUID groupId,
            @RequestBody CreationSubjectDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Обновление предмета")
    @PutMapping("subjects/{subjectId}")
    public void updateSubject(
            @PathVariable UUID subjectId,
            @RequestBody CreationSubjectDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Удаление предмета")
    @DeleteMapping("subjects/{subjectId}")
    public void deleteSubject(
            @PathVariable UUID subjectId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

}
