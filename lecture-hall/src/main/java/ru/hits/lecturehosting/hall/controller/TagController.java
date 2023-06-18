package ru.hits.lecturehosting.hall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.TagValueDto;
import ru.hits.lecturehosting.hall.dto.search.SearchTagDto;
import ru.hits.lecturehosting.hall.dto.search.SearchVideoDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TagController {

    @PostMapping("groups/{groupId}/tags/search")
    public PageDto<TagDto> getTags(
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchTagDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    /*@GetMapping("groups/{groupId}/tags/{tagId}/values")
    public PageDto<TagValueDto> getTagValues(
            @PathVariable UUID groupId,
            @PathVariable UUID tagId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }*/

}
