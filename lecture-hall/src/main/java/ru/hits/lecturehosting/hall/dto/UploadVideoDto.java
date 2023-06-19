package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class UploadVideoDto implements Serializable {

    @Schema(name = "Ссылка для загрузки файла видео")
    private final String uploadUrl;

}
