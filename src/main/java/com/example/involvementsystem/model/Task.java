package com.example.involvementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_operation")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime created;

    private String name;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private String description;

    private BigDecimal maticAward;

    private BigDecimal rubleAward;

    private BigDecimal nftAward;

    private int ratingAward;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;
}
