package ru.hits.lecturehosting.hall.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.hits.lecturehosting.hall.dto.special.UsingTagDto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchVideoDto implements Serializable {

    private String textFilter;
    private List<UUID> subjectFilter;
    private List<UsingTagDto> tagFilter;

}
