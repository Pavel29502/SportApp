package com.example.Sport.bean;

import com.example.Sport.dto.TypeTrainingRequestDTO;
import com.example.Sport.repository.TypeTrainingRepository;
import com.example.Sport.service.ExerciseService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "type_training")
public class TypeTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "typeTraining")
    private List<Training> trainings;

}

