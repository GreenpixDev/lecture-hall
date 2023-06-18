package ru.hits.lecturehosting.hall.dto.update;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UpdateInvitationDto implements Serializable {

    private final String name;

    private final int usageLimit;

    private final LocalDateTime expirationDateTime;

}
