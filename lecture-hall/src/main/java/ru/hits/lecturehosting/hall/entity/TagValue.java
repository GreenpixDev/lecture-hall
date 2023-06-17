package ru.hits.lecturehosting.hall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.hits.lecturehosting.hall.entity.id.TagValueId;

import java.util.UUID;

@Getter
@Setter
@Table(name = "tag_value")
@Entity
@IdClass(TagValueId.class)
public class TagValue {

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @Id
    @Column(name = "name", nullable = false)
    private String value;

}