package ru.hits.lecturehosting.hall.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QSort;
import ru.hits.lecturehosting.hall.entity.Group;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID>, JpaSpecificationExecutor<Group> {

    @Query("select g from Group g join g.members m where m.user.id = :memberId and g.name like :nameExpression")
    Page<Group> searchAll(UUID memberId, String nameExpression, Pageable pageable);

    @Query("select g from Group g join g.members m where m.user.id = :memberId and m.administrator and g.name like :nameExpression")
    Page<Group> searchAllIsAdmin(UUID memberId, String nameExpression, Pageable pageable);

}
