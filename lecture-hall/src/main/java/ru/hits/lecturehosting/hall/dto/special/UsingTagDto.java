package ru.hits.lecturehosting.hall.dto.special;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsingTagDto implements Serializable {

    private String key;

    private List<String> values;

}
