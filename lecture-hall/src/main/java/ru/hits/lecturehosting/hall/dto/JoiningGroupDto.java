package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Data
public class JoiningGroupDto implements Serializable {

    private final String invitationCode;

}
