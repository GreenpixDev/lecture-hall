package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Video;

import java.util.Optional;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {

    // TODO label
    @Query("select v from Video v where v.group.id = :groupId and " +
            "(v.title like :textExpression or v.description like :textExpression)")
    Page<Video> searchAll(UUID groupId, String textExpression, Pageable pageable);

    Optional<Video> findByVkId(Integer vkId);

}
