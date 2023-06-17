package ru.hits.lecturehosting.video.service;

import java.io.File;
import java.net.URI;

public interface UploadService {

    void uploadVideo(URI uploadUri, File videoFile);

}
