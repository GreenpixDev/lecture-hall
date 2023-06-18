package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class VideoDto implements Serializable {

    private final UUID id;

    private final String title;

    private final String description;

    private final LocalDateTime publicationDateTime;

    private final String playerUrl;

}
