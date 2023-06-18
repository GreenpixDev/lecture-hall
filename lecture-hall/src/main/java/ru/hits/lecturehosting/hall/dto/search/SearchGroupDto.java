package ru.hits.lecturehosting.hall.dto.search;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchGroupDto implements Serializable {

    private final String nameFilter;

}
