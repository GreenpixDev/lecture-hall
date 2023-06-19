package ru.hits.lecturehosting.hall.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.hits.lecturehosting.hall.dto.TagDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreationVideoDto implements Serializable {

    private String title;

    private String description;

    private UUID subjectId;

    @Schema(description = "Используемые теги и используемые значения тегов в видео")
    private List<TagDto> tags;

}
