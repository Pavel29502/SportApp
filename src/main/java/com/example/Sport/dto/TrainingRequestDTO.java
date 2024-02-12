package com.example.Sport.dto;

import com.example.Sport.bean.Body;
import com.example.Sport.bean.TypeTraining;
import com.example.Sport.bean.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TrainingRequestDTO {

    private String title;

    private String description;

    private Long userId;

    private Long time;

    private Long typeTrainingId;

    private Body body;
}

