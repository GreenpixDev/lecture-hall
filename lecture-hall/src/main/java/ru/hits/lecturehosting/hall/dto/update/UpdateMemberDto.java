package ru.hits.lecturehosting.hall.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberDto implements Serializable {

    private Boolean administration;

}
