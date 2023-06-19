package ru.hits.lecturehosting.hall.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVideoDto implements Serializable {

    private String title;

    private String description;

    private UUID subjectId;

    private Map<String, List<String>> tags;

}
