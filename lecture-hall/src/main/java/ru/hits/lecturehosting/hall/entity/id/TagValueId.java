package ru.hits.lecturehosting.hall.entity.id;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class TagValueId implements Serializable {

    private final UUID tag;

    private final String value;

}
