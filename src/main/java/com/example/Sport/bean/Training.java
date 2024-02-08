package com.example.Sport.bean;

import com.example.Sport.dto.TrainingRequestDTO;
import com.example.Sport.dto.TypeTrainingRequestDTO;
import com.example.Sport.repository.TrainingRepository;
import com.example.Sport.repository.TypeTrainingRepository;
import com.example.Sport.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private Long time;

    @ManyToOne
    @JoinColumn(name = "type_training_id")
    @JsonIgnore
    private TypeTraining typeTraining;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "body")
    private Body trainingBody;
}










