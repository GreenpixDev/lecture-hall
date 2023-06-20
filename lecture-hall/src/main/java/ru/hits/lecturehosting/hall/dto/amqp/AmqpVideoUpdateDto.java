package ru.hits.lecturehosting.hall.dto.amqp;

import lombok.Data;

import java.util.UUID;

@Data
public class AmqpVideoUpdateDto {

    private final UUID videoId;
    private final String playerUrl;

}
