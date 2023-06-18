package ru.hits.lecturehosting.hall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SubjectController {

    @GetMapping("groups/{groupId}/subjects")
    public PageDto<SubjectDto> getSubjects(
            @PathVariable UUID groupId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @GetMapping("groups/{groupId}/subjects")
    public void createSubject(
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
