package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.entity.Tag;
import ru.hits.lecturehosting.hall.mapper.TagMapper;

import java.util.List;

@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto toDto(Tag tag) {
        return new TagDto(
                tag.getId(),
                tag.getName(),
                List.of() // TODO
        );
    }
}
