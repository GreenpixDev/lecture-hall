package ru.hits.lecturehosting.hall.entity.id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class TagValueId implements Serializable {

    private UUID tag;

    private String value;

}
