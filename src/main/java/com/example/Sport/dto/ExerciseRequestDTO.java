package com.example.Sport.dto;

import com.example.Sport.bean.Body;
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

    private Body body;

    private String description;

    private String url;

    private String orderUse;

    private Long time;

    private Long muscleId;

    private String contradictions;

}