package com.example.Sport.controller;

import com.example.Sport.bean.Exercise;
import com.example.Sport.service.ExerciseService;
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

    @PostMapping("/save")
    public Exercise saveExercise(@RequestBody Exercise exercise) {
        return exerciseService.saveExercise(exercise);
    }

    @PostMapping("/update")
    public Exercise updateExercise(@RequestBody Exercise exercise) {
        return exerciseService.saveExercise(exercise);
    }

    @DeleteMapping("{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExerciseById(id);
    }
}
