package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Tag;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

    @Query("select t from Tag t join t.labels l where t.group.id = :groupId and " +
            "(t.name like :textExpression or l.value like :textExpression)")
    Page<Tag> searchAll(UUID groupId, String textExpression, Pageable pageable);

    Optional<Tag> findByName(String name);

}
