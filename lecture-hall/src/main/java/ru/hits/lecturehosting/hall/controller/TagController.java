package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.search.SearchTagDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.service.TagService;

import java.util.UUID;

@Tag(name = "tag")
@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Tag(name = "group")
    @Operation(summary = "Поиск тегов в группе")
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
