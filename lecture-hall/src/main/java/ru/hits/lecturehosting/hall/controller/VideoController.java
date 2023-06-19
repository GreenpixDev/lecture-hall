package ru.hits.lecturehosting.hall.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.UploadVideoDto;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.search.SearchVideoDto;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Tag(name = "video")
@RestController
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @Tag(name = "group")
    @Operation(summary = "Поиск видео в группе")
    @PostMapping("groups/{groupId}/videos/search")
    public PageDto<VideoDto> getGroupVideos(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "count", defaultValue = "20") int count,
            @RequestBody SearchVideoDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Получение информации о видео")
    @GetMapping("videos/{videoId}")
    public VideoDto getVideo(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID videoId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Tag(name = "group")
    @Operation(summary = "Создание видео в группе")
    @PostMapping("groups/{groupId}/videos/new")
    public UploadVideoDto createGroupVideo(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID groupId,
            @RequestBody CreationVideoDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Обновление видео")
    @PutMapping("videos/{videoId}")
    public void updateVideo(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID videoId,
            @RequestBody CreationVideoDto dto
    ) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Operation(summary = "Удаление видео")
    @DeleteMapping("videos/{videoId}")
    public void deleteVideo(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable UUID videoId
    ) {
        throw new UnsupportedOperationException(); // TODO
    }
}
