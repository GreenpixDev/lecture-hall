package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.User;

import java.util.UUID;

public interface RecordRepository extends JpaRepository<Record, UUID> {
}
