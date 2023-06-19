package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateSubjectDto;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.mapper.SubjectMapper;

@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectDto toDto(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getName()
        );
    }

    @Override
    public Subject toEntity(CreationSubjectDto dto) {
        return Subject.builder()
                .name(dto.getName())
                .build();
    }

    @Override
    public Subject partialUpdate(UpdateSubjectDto dto, Subject subject) {
        if (dto.getName() != null) {
            subject.setName(dto.getName());
        }
        return subject;
    }
}
