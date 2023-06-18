package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.Subject;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
}
