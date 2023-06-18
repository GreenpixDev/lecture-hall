package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class TagDto implements Serializable {

    private final String key;

    private final List<String> values;

}
