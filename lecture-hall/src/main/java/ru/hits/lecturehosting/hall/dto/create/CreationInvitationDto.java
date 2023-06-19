package ru.hits.lecturehosting.hall.dto.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreationInvitationDto implements Serializable {

    private int usageLimit;

    private LocalDateTime expirationDateTime;

}
