package com.example.Sport.service;

import com.example.Sport.bean.*;
import com.example.Sport.dto.MuscleRequestDTO;
import com.example.Sport.repository.ExerciseRepository;
import com.example.Sport.repository.MuscleRepository;
import com.example.Sport.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class MuscleService {

    private final MuscleRepository muscleRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    public MuscleService(MuscleRepository repository, UserRepository userRepository,
                         ExerciseRepository exerciseRepository) {
        this.muscleRepository = repository;
        this.userRepository = userRepository;
        this.exerciseRepository =exerciseRepository;
    }

    public List<Muscle> getAllMuscles() {
        return muscleRepository.findAll();
    }

    public Optional<Muscle> getMuscleById(Long id) {
        return muscleRepository.findById(id);
    }

    public Muscle saveMuscle(MuscleRequestDTO muscleRequestDTO) {

        Muscle muscle = new Muscle();
        muscle.setTitle(muscleRequestDTO.getTitle());
//        muscle.setMuscleBody(muscleRequestDTO.getBody());
        muscle.setMuscleBody(Body.getById(muscleRequestDTO.getBody()));

        //delete
        // Связываем упражнение с мышцей, если оно существует
//        if (exercise != null) {
//            muscle.getExercises().add(exercise);
//        }

        // Сохраняем мышцу
        return muscleRepository.save(muscle);
    }

    public void deleteMuscle(Long id) {
        muscleRepository.deleteById(id);
    }

}
