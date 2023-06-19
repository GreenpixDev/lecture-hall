package ru.hits.lecturehosting.hall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class InvitationDto implements Serializable {

    private final UUID id;

    @Schema(name = "Код приглашения в группу")
    private final String code;

    @Schema(name = "Количество использований кода")
    private final int usages;

    @Schema(name = "Лимит на использование кода")
    private final int usageLimit;

    @Schema(name = "Дата и время истечения приглашения")
    private final LocalDateTime expirationDateTime;

}
