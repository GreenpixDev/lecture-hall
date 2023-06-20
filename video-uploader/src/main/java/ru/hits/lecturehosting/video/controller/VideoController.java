package ru.hits.lecturehosting.video.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hits.lecturehosting.video.service.VideoUploadService;

import java.util.UUID;

@RestController
@RequestMapping("video/upload")
@RequiredArgsConstructor
public class VideoController {

    private final VideoUploadService videoUploadService;

    @PostMapping
    public UUID createUpload(
            @RequestParam("access_token") String accessToken,
            @RequestBody String vkUploadUrl
    ) {
        return videoUploadService.createUpload(vkUploadUrl);
    }

    @PostMapping("{id}")
    public void uploadFile(
            @PathVariable
            UUID id,

            @RequestPart(name = "video_file")
            MultipartFile videoFile
    ) {
        videoUploadService.uploadFile(videoUploadService.lockUpload(id), videoFile);
    }

}
