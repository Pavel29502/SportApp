package com.example.Sport.service;

import com.example.Sport.bean.Exercise;
import com.example.Sport.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository repository) {
        this.exerciseRepository = repository;
    }

    public List<Exercise> getAllExercisies() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> getExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExerciseById(Long id) {
        exerciseRepository.deleteById(id);
    }
}
