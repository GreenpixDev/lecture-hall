package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class JoiningGroupDto implements Serializable {

    @Schema(description = "Код приглашения в группу")
    private final String invitationCode;

}
