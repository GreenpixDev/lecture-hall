package ru.hits.lecturehosting.hall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "\"invitation\"")
@Entity
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "creation", nullable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "usages", nullable = false)
    private Integer usages;

    @Column(name = "limit")
    private Integer usageLimit;

    @Column(name = "expiration")
    private LocalDateTime expirationDateTime;

}