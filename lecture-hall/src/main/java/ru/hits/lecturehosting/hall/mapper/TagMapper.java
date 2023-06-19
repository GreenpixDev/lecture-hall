package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Tag;

public interface TagMapper {

    TagDto toDto(Tag tag);

}
