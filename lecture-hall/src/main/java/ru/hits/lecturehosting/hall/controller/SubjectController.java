package ru.hits.lecturehosting.hall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.search.SearchInvitationDto;
import ru.hits.lecturehosting.hall.dto.search.SearchSubjectDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SubjectController {

    @PostMapping("groups/{groupId}/subjects/search")
    public PageDto<SubjectDto> getSubjects(
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchSubjectDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PostMapping("groups/{groupId}/subjects")
    public void createSubject(
            @PathVariable UUID groupId,
            @RequestBody CreationSubjectDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @PutMapping("groups/{groupId}/subjects")
    public void updateSubject(
            @PathVariable UUID groupId,
            @RequestBody CreationSubjectDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @DeleteMapping("subjects/{subjectId}")
    public void deleteSubject(
            @PathVariable UUID subjectId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

}
