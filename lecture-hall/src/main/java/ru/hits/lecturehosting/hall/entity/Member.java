package ru.hits.lecturehosting.hall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.hits.lecturehosting.hall.entity.id.MemberId;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "\"member\"")
@Entity
@IdClass(MemberId.class)
public class Member {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "admin", nullable = false)
    private Boolean administrator;

    @Column(name = "joining", nullable = false)
    private LocalDateTime joiningDateTime;

}