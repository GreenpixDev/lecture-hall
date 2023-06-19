package ru.hits.lecturehosting.hall.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvitationDto implements Serializable {

    private Integer usageLimit;

    private LocalDateTime expirationDateTime;

}
