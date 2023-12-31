package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByVkId(Integer vkId);

}
