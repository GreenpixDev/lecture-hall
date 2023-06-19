package ru.hits.lecturehosting.hall.mapper;

import org.springframework.data.domain.Page;
import ru.hits.lecturehosting.hall.dto.PageDto;

public interface PageMapper {

    <E> PageDto<E> toDto(Page<E> page);

}
