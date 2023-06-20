package ru.hits.lecturehosting.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.video.entity.VideoUpload;

import java.util.UUID;

public interface VideoUploadRepository extends JpaRepository<VideoUpload, UUID> {



}