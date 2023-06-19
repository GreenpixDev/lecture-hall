package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageDto<T> implements Serializable {

    @Schema(name = "Номер страницы")
    private final int pageNumber;

    @Schema(name = "Размер страницы")
    private final int pageSize;

    @Schema(name = "Количество элементов на странице")
    private final int numberOfElements;

    @Schema(name = "Всего страниц")
    private final int totalPages;

    @Schema(name = "Всего элементов")
    private final long totalElements;

    @Schema(name = "Элементы страницы")
    private final List<T> content;

}
