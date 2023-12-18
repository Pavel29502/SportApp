package com.example.Sport.dto;

import com.example.Sport.bean.Body;
import com.example.Sport.bean.Exercise;
import com.example.Sport.bean.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MuscleRequestDTO {

    private String title;

    private Long userId;

    private Long exerciseId;

    private Long body;

}

