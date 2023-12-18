package com.example.Sport.service;

import com.example.Sport.bean.*;
import com.example.Sport.dto.ExerciseRequestDTO;
import com.example.Sport.dto.MuscleRequestDTO;
import com.example.Sport.dto.TypeTrainingRequestDTO;
import com.example.Sport.repository.ExerciseRepository;
import com.example.Sport.repository.MuscleRepository;
import com.example.Sport.repository.TypeTrainingRepository;
import com.example.Sport.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        Exercise exercise = exerciseRepository.findById(muscleRequestDTO.getExerciseId()).orElse(null);
//        User user = userRepository.findById(muscleRequestDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException(
//                "User not found"));
        User user = userRepository.findById(muscleRequestDTO.getUserId()).orElse(null);
        Set<Exercise> exerciseSet = new HashSet<>();
        exerciseSet.add(exercise);

        muscle.setTitle(muscleRequestDTO.getTitle());
        muscle.setUser(user);
        muscle.setMuscleBody(Body.getById(muscleRequestDTO.getBody()));

        return muscleRepository.save(muscle);
    }

//    public Exercise saveExercise(ExerciseRequestDTO exerciseRequestDTO) {
//        Exercise exercise = new Exercise();
//        Muscle muscle = muscleRepository.findById(exerciseRequestDTO.getMuscleId()).orElse(null);
//        Set<Muscle> muscleSet = new HashSet<>();
//        muscleSet.add(muscle);
//
//        exercise.setTitle(exerciseRequestDTO.getTitle());
//        exercise.setTime(exerciseRequestDTO.getTime());
//        exercise.setTime(exerciseRequestDTO.getTime());
//        exercise.setMuscles(muscleSet);
//        return exerciseRepository.save(exercise);



    public Muscle updateMuscle(Long id, MuscleRequestDTO muscleRequestDTO) {
        Muscle existMuscle = muscleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Muscle not found with id: " + id));

        if (muscleRequestDTO.getTitle() != null) {
            existMuscle.setTitle(muscleRequestDTO.getTitle());
        }
        if (muscleRequestDTO.getUserId() != null) {
            User user = userRepository.findById(muscleRequestDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException(
                    "User not found with id: " + id));
            existMuscle.setUser(user);
            existMuscle.setMuscleBody(Body.getById(muscleRequestDTO.getBody()));
        }
        return muscleRepository.save(existMuscle);
    }
    public void deleteMuscle(Long id) {
        muscleRepository.deleteById(id);
    }
}
