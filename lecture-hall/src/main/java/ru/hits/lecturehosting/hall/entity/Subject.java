package ru.hits.lecturehosting.hall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(schema = "public", name = "subject", uniqueConstraints = @UniqueConstraint(
        columnNames = {"group_id", "name"}
))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "creation", nullable = false)
    @Builder.Default
    private LocalDateTime creationDateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Video> videos = new LinkedHashSet<>();

}