package com.example.Sport.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Time;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "body")
    private Body exerciseBody;

    @Column(name = "description_exercise")
    private String description;

    @Column(name = "url")
    private String url;

//    @Column(name = "gif_id")
//    private String gifId;

    @Column(name = "order_use", length = 1000)
    private String orderUse;

    @Column(name = "time")
    private Long time;

    @Column(name = "contradictions", length = 1000)
    private String contradictions;

    @ManyToMany
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    private Set<Muscle> muscles;
}
