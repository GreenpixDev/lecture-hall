package ru.hits.lecturehosting.hall.dto.search;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Schema(description = "Пока пустая и бесполезная DTO. Мейби в будущем будет поиск по имени")
public class SearchMemberDto implements Serializable {

}
