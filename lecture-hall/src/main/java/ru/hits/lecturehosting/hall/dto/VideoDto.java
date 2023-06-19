package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class VideoDto implements Serializable {

    private final UUID id;

    private final String title;

    private final String description;

    private final LocalDateTime creationDateTime;

    private final LocalDateTime recordingDateTime;

    private final Map<String, List<String>> tags;

    private final String playerUrl;

}
