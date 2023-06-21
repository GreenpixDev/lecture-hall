package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hits.lecturehosting.hall.entity.Ban;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.id.BanId;
import ru.hits.lecturehosting.hall.entity.id.MemberId;

import java.util.UUID;

public interface BanRepository extends JpaRepository<Ban, BanId> {

    @Query("select b from Ban b where b.group.id = :groupId")
    Page<Ban> searchAll(UUID groupId, Pageable pageable);

}
