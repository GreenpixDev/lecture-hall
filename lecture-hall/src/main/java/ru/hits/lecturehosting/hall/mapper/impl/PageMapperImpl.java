package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.mapper.PageMapper;

@Component
public class PageMapperImpl implements PageMapper {

    @Override
    public <E> PageDto<E> toDto(Page<E> page) {
        return new PageDto<>(
                page.getNumber(),
                page.getSize(),
                page.getNumberOfElements(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getContent()
        );
    }
}
