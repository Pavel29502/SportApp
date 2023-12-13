package com.example.Sport.bean;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description_training")
    private String description;

    @Column(name = "time")
    private int time;

    @ManyToOne
    @JoinColumn(name = "type_training_id")
    private TypeTraining typeTraining;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "body")
//  private String trainingBody;
    private Body trainingBody;

}








//    @JoinColumn(name = "user_id", insertable = false, updatable = false)




//    @JoinColumn(name = "type_training_id", insertable = false, updatable = false)