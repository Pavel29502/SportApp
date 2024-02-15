package com.example.Sport.service;

import com.example.Sport.bean.Body;
import com.example.Sport.bean.Exercise;
import com.example.Sport.bean.Muscle;
import com.example.Sport.dto.ExerciseRequestDTO;
import com.example.Sport.dto.MuscleRequestDTO;
import com.example.Sport.repository.ExerciseRepository;
import com.example.Sport.repository.MuscleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final MuscleRepository muscleRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, MuscleRepository muscleRepository) {
        this.exerciseRepository = exerciseRepository;
        this.muscleRepository = muscleRepository;
    }

    public List<Exercise> getAllExercisies() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> getExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }

    public Exercise saveExercise(ExerciseRequestDTO exerciseRequestDTO) {
        Exercise exercise = new Exercise();
        exercise.setTitle(exerciseRequestDTO.getTitle());
        exercise.setDescription(exerciseRequestDTO.getDescription());
        exercise.setOrderUse(exerciseRequestDTO.getOrderUse());
        exercise.setTime(exerciseRequestDTO.getTime());
        exercise.setContradictions(exerciseRequestDTO.getContradictions() != null ? exerciseRequestDTO.getContradictions() : "");
        exercise.setExerciseBody(exerciseRequestDTO.getBody());
        exercise.setUrl(exerciseRequestDTO.getUrl());
        // Инициализация пустого множества для мышц
        Set<Muscle> muscles = new HashSet<>();
        // Получаем мышцу по ее id
        Muscle muscle = muscleRepository.findById(exerciseRequestDTO.getMuscleId()).orElse(null);
        // Устанавливаем мышцу упражнения, если она существует
//        if (muscle != null) {
//            muscles.add(muscle);
//        }
        // Устанавливаем мышцы упражнения
        exercise.setMuscles(muscles);

        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExerciseById(Long id) {
        exerciseRepository.deleteById(id);
    }
}

