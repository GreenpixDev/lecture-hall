package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageDto<T> implements Serializable {

    @Schema(description = "Номер страницы")
    private final int pageNumber;

    @Schema(description = "Размер страницы")
    private final int pageSize;

    @Schema(description = "Количество элементов на странице")
    private final int numberOfElements;

    @Schema(description = "Всего страниц")
    private final int totalPages;

    @Schema(description = "Всего элементов")
    private final long totalElements;

    @Schema(description = "Элементы страницы")
    private final List<T> content;

}
