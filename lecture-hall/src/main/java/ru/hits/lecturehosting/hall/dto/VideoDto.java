package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class VideoDto implements Serializable {

    private final UUID id;

    private final String title;

    private final String description;

    @Schema(name = "Дата создании видео (публикации его на сайт)")
    private final LocalDateTime creationDateTime;

    @Schema(name = "Дата записи лекции")
    private final LocalDateTime recordingDateTime;

    @Schema(name = "Используемые теги и используемые значения тегов в видео")
    private final List<TagDto> tags;

    @Schema(name = "Ссылка на VK видеоплеер")
    private final String playerUrl;

}
