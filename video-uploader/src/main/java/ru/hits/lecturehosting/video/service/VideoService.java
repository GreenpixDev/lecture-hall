package ru.hits.lecturehosting.video.service;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {

    void upload(String name, MultipartFile videoFile);

}
