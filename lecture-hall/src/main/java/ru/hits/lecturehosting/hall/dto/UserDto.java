package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserDto implements Serializable {

    private final UUID id;

    private final Integer vkId;

    private final String firstName;

}
