package ru.hits.lecturehosting.hall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.hits.lecturehosting.hall.entity.id.MemberId;

import java.util.UUID;

@Getter
@Setter
@Table(name = "member")
@Entity
@IdClass(MemberId.class)
public class Member {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "admin")
    private boolean administrator;

}