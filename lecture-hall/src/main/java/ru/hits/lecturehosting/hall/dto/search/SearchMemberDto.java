package ru.hits.lecturehosting.hall.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchMemberDto implements Serializable {

    private String nameFilter;

}
