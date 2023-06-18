package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MemberDto implements Serializable {

    private final UserDto user;

    private final LocalDateTime joiningDateTime;

    private final boolean administrator;

}
