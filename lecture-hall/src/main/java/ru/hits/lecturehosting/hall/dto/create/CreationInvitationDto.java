package ru.hits.lecturehosting.hall.dto.create;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CreationInvitationDto implements Serializable {

    private final String name;

    private final int usageLimit;

    private final LocalDateTime expirationDateTime;

}
