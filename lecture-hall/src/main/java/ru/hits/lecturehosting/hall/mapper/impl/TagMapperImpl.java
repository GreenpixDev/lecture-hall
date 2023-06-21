package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.entity.Label;
import ru.hits.lecturehosting.hall.entity.Tag;
import ru.hits.lecturehosting.hall.mapper.TagMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto toDto(Tag tag) {
        return new TagDto(
                tag.getId(),
                tag.getName(),
                tag.getLabels().stream().map(Label::getValue).collect(Collectors.toList())
        );
    }
}
