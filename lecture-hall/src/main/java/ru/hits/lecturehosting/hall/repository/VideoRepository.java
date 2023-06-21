package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hits.lecturehosting.hall.entity.Label;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Video;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {

    @Query("select v from Video v where v.group.id = :groupId and v.playerUrl is not null and " +
            "(v.title like :textExpression or v.description like :textExpression) and " +
            "((select count(l) from v.labels l where l in :labels) >= :labelCount)")
    Page<Video> searchAll(UUID groupId, String textExpression, List<Label> labels, int labelCount, Pageable pageable);

    @Query("select v from Video v where v.group.id = :groupId and v.playerUrl is not null and " +
            "(v.title like :textExpression or v.description like :textExpression) and " +
            "((select count(l) from v.labels l where l in :labels) >= :labelCount) and " +
            "v.subject.id in :subjectIds")
    Page<Video> searchAllBySubjectId(UUID groupId, String textExpression, List<Label> labels, int labelCount, List<UUID> subjectIds, Pageable pageable);


    Optional<Video> findByVkId(Integer vkId);

}
