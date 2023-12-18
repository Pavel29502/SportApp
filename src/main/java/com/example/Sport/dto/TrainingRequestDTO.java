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

    private Long body;
}

//@Table(name = "training")
//public class Training {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "description_training")
//    private String description;
//
//    @Column(name = "time")
//    private int time;
//
//    @ManyToOne
//    @JoinColumn(name = "type_training_id")
//    private TypeTraining typeTraining;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private User user;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "body")
////  private String trainingBody;
//    private Body trainingBody;
