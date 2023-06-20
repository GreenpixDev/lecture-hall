package ru.hits.lecturehosting.hall.dto.special;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class JoiningGroupDto implements Serializable {

    @Schema(description = "Код приглашения в группу")
    private String invitationCode;

}
