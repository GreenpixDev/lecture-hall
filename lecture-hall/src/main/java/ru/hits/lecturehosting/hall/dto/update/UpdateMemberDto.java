package ru.hits.lecturehosting.hall.dto.update;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateMemberDto implements Serializable {

    private final boolean administration;

}
