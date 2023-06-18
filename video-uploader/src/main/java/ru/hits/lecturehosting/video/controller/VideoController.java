package ru.hits.lecturehosting.video.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.hits.lecturehosting.video.service.VideoService;

import java.util.UUID;

@RestController
@RequestMapping("video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping
    public void getVideoState() {
        // TODO
    }

    @PostMapping
    public void createVideo() {
        // TODO
    }

    @PostMapping("{id}/upload")
    public void uploadFile(
            @PathVariable
            UUID id,

            @RequestPart(name = "video_file")
            MultipartFile videoFile
    ) {
        videoService.upload("MockName", videoFile);
    }

}
