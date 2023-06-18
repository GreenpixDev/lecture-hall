package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreatedInvitationDto implements Serializable {

    private final String generatedCode;

}
