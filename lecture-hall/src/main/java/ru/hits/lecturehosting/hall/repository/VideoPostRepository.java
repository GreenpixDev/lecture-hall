package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.VideoPost;

import java.util.UUID;

public interface VideoPostRepository extends JpaRepository<VideoPost, UUID> {
}
