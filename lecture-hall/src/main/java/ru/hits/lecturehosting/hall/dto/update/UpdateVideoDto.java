package ru.hits.lecturehosting.hall.dto.update;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class UpdateVideoDto implements Serializable {

    private final String title;

    private final String description;

    private final UUID subjectId;

    private final Map<String, List<String>> tags;

}
