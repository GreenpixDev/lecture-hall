package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class GroupDto implements Serializable {

    private final UUID id;

    private final String name;

}
