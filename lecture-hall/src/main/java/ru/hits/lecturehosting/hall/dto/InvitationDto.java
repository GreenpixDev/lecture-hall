package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class InvitationDto implements Serializable {

    private final UUID id;

    private final String code;

    private final int usages;

    private final int usageLimit;

    private final LocalDateTime expirationDateTime;

}
