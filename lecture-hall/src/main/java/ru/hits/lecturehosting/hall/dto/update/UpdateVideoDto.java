package ru.hits.lecturehosting.hall.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.special.UsingTagDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVideoDto implements Serializable {

    private String title;

    private String description;

    private LocalDateTime recordingDateTime;

    private UUID subjectId;

    @Schema(description = "Используемые теги и используемые значения тегов в видео")
    private List<UsingTagDto> tags;

}
