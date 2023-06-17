package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.Group;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {

}
