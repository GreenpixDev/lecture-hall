package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserDto implements Serializable {

    private final UUID id;

    @Schema(description = "Идентификатор пользователя в VK")
    private final Integer vkId;

}
