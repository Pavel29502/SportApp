package com.example.Sport.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "exercise_muscle")
public class ExerciseMuscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exerciseId;

    @ManyToOne
    @JoinColumn(name = "muscle_id")
    private Muscle muscleId;
}
