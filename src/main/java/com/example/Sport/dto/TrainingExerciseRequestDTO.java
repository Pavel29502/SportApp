package com.example.Sport.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrainingExerciseRequestDTO {

    private Long trainingId;

    private Long exerciseId;

    private int approach;

    private int priority;
}