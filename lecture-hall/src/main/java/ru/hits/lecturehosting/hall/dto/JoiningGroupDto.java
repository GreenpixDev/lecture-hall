package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JoiningGroupDto implements Serializable {

    private final String invitationCode;

}
