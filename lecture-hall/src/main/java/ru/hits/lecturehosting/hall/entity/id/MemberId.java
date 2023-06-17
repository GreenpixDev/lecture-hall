package ru.hits.lecturehosting.hall.entity.id;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class MemberId implements Serializable {

    private final UUID user;

    private final UUID group;

}
