package ru.hits.lecturehosting.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.video.entity.UploadedVideo;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<UploadedVideo, UUID> {



}