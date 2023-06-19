package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateSubjectDto;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.Subject;

public interface SubjectMapper {

    SubjectDto toDto(Subject subject);

    Subject toEntity(CreationSubjectDto dto);

    Subject partialUpdate(UpdateSubjectDto dto, Subject subject);

}
