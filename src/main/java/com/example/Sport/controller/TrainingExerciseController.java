package com.example.Sport.controller;


import com.example.Sport.bean.Exercise;
import com.example.Sport.bean.TrainingExercise;
import com.example.Sport.dto.TrainingExerciseRequestDTO;
import com.example.Sport.service.TrainingExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/training-exercise")
public class TrainingExerciseController {
    private final TrainingExerciseService trainingExerciseService;

    public TrainingExerciseController(TrainingExerciseService trainingExerciseService) {
        this.trainingExerciseService = trainingExerciseService;
    }

    @GetMapping("/training/{trainingId}/exercises")
    public List<Exercise> getExercisesForTraining(@PathVariable Long trainingId) {
        return trainingExerciseService.getExercisesForTraining(trainingId);
    }
////////////////
    @PostMapping("/save")
    public ResponseEntity<String> saveTrainingExercise(@RequestBody TrainingExerciseRequestDTO trainingExerciseRequestDTO) {
        trainingExerciseService.saveTrainingExercise(trainingExerciseRequestDTO);
        return new ResponseEntity<>("Training exercise saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingExercise>> getAllTrainingExercises() {
        List<TrainingExercise> trainingExercises = trainingExerciseService.getAllTrainingExercises();
        return new ResponseEntity<>(trainingExercises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingExercise> getTrainingExerciseById(@PathVariable Long id) {
        TrainingExercise trainingExercise = trainingExerciseService.getTrainingExerciseById(id)
                .orElse(null);
        if (trainingExercise != null) {
            return new ResponseEntity<>(trainingExercise, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateTrainingExercise(@PathVariable Long id, @RequestBody TrainingExerciseDTO updatedTrainingExerciseDTO) {
//        trainingExerciseService.updateTrainingExercise(id, updatedTrainingExerciseDTO);
//        return new ResponseEntity<>("Training exercise updated successfully", HttpStatus.OK);
//    }
//}
