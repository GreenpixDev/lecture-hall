package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.id.MemberId;

import java.util.List;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, MemberId> {

    List<Member> findAllByUserId(UUID id);

    List<Member> findAllByUserVkId(Integer id);

    List<Member> findAllByGroupId(UUID id);

}
