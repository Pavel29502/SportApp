package com.example.Sport.controller;

import com.example.Sport.bean.Exercise;
import com.example.Sport.dto.ExerciseRequestDTO;
import com.example.Sport.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService service) {
        this.exerciseService = service;
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercisies();
    }

    @GetMapping("{id}")
    public Exercise getExerciseById(@PathVariable Long id) {
        return exerciseService.getExerciseById(id).orElse(null);
    }

//    @PostMapping("/save")
//    public Exercise saveExercise(@RequestBody ExerciseRequestDTO exercise) {
//        return exerciseService.saveExercise(exercise);
//    }
    @PostMapping("/save")
    public ResponseEntity<Exercise> saveExercise(@RequestBody ExerciseRequestDTO exerciseRequestDTO) {
        Exercise savedExercise = exerciseService.saveExercise(exerciseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExercise);

//    @PutMapping("/update")
//    public Exercise updateExercise(@RequestBody Exercise exercise) {
//        return exerciseService.saveExercise(exercise);
//    }

/*    @DeleteMapping("{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExerciseById(id);
    }*/
    }
}