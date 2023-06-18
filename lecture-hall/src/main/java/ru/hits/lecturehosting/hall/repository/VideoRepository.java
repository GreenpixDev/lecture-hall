package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.Video;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
}
