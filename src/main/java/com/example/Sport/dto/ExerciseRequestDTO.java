package com.example.Sport.dto;

import com.example.Sport.bean.Muscle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExerciseRequestDTO {

    private String title;

    private String orderUse;

    private Long time;

    private Long muscleId;

    private String contradiction;

}

//@Table(name = "exercise")
//public class Exercise {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "title", nullable = false, length = 50)
//    private String title;
//
//    @Column(name = "order_use", length = 1000)
//    private String orderUse;
//
//    @Column(name = "time")
//    private Time time;
//
//    @Column(name = "contradictions", length = 1000)
//    private String contradictions;
//
//    @ManyToMany
//    @JoinTable(
//            name = "exercise_muscle",
//            joinColumns = @JoinColumn(name = "exercise_id"),
//            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
//    private Set<Muscle> muscles;
//}