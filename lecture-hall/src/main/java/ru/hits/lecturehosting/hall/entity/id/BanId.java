package ru.hits.lecturehosting.hall.entity.id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class BanId implements Serializable {

    private UUID user;

    private UUID group;

}
