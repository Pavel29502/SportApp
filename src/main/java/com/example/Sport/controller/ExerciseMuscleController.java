package com.example.Sport.controller;


import com.example.Sport.bean.ExerciseMuscle;
import com.example.Sport.dto.ExerciseMusclesRequestDTO;
import com.example.Sport.service.ExerciseMuscleService;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise1")
public class ExerciseMuscleController {

    private final ExerciseMuscleService exerciseMuscleService;

    public ExerciseMuscleController(ExerciseMuscleService service) {
        this.exerciseMuscleService = service;
    }

    public List<ExerciseMuscle> getAllExerciseMuscle() {
        return exerciseMuscleService.getAllExerciseMuscle();
    }

    @PostMapping("/save")
    public ResponseEntity<ExerciseMuscle> saveExerciseMuscle(@RequestBody ExerciseMusclesRequestDTO requestDTO) {
        ExerciseMuscle saveExerciseMuscle = exerciseMuscleService.saveExerciseMuscle(requestDTO);
        return new ResponseEntity<>(saveExerciseMuscle, HttpStatus.CREATED);
    }



}
