package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Invitation;
import ru.hits.lecturehosting.hall.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface InvitationRepository extends JpaRepository<Invitation, UUID> {

    @Query("select i from Invitation i where i.group.id = :groupId")
    Page<Invitation> searchAll(UUID groupId, Pageable pageable);

}
