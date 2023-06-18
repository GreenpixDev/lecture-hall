package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberDto implements Serializable {

    private final UserDto user;

    private final boolean administrator;

}
