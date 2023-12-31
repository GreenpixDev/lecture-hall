package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.SecurityConst;
import ru.hits.lecturehosting.hall.config.jwt.JwtUser;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.search.SearchTagDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.service.TagService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Tag(name = "tag")
@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Tag(name = "group")
    @Operation(summary = "Поиск тегов в группе")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PostMapping("groups/{groupId}/tags/search")
    public PageDto<TagDto> getTags(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchTagDto dto
    ) {
        return tagService.getGroupTags(user, groupId, page - 1, count, dto);
    }

    @Operation(summary = "Информация о теге")
    @SecurityRequirement(name = SecurityConst.BEARER)
    @PostMapping("tags/{tagId}")
    public TagDto getTags(
            @AuthenticationPrincipal JwtUser user,
            @PathVariable UUID tagId
    ) {
        return tagService.getTag(user, tagId);
    }

}
