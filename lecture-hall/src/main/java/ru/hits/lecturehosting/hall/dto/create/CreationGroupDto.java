package ru.hits.lecturehosting.hall.dto.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreationGroupDto implements Serializable {

    private String name;

}
