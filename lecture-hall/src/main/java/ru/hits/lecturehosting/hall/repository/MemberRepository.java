package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.id.MemberId;

import java.util.List;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, MemberId> {

    @Query("select m from Member m where m.group.id = :groupId")
    Page<Member> searchAll(UUID groupId, Pageable pageable);

}
