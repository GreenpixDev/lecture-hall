package ru.hits.lecturehosting.video.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hits.lecturehosting.video.entity.VideoUpload;

import java.util.UUID;

public interface VideoUploadService {

    UUID createUpload(String url);

    VideoUpload lockUpload(UUID uploadId);

    void uploadFile(VideoUpload upload, MultipartFile videoFile);

}
