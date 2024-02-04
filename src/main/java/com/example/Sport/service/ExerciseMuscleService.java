package com.example.Sport.service;

import com.example.Sport.bean.Exercise;
import com.example.Sport.bean.ExerciseMuscle;
import com.example.Sport.bean.Muscle;
import com.example.Sport.dto.ExerciseMusclesRequestDTO;
import com.example.Sport.dto.ExerciseRequestDTO;
import com.example.Sport.repository.ExerciseMuscleRepository;
import com.example.Sport.repository.ExerciseRepository;
import com.example.Sport.repository.MuscleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseMuscleService {

    private final ExerciseMuscleRepository exerciseMuscleRepository;
    private final ExerciseRepository exerciseRepository;
    private final MuscleRepository muscleRepository;


    public ExerciseMuscleService(ExerciseMuscleRepository exerciseMuscleRepository,
                                 ExerciseRepository exerciseRepository,
                                 MuscleRepository muscleRepository) {
        this.exerciseMuscleRepository = exerciseMuscleRepository;
        this.exerciseRepository = exerciseRepository;
        this.muscleRepository = muscleRepository;
    }

    public List<ExerciseMuscle> getAllExerciseMuscle() {
        return exerciseMuscleRepository.findAll();
    }

    public Optional<ExerciseMuscle> getExerciseMuscleId(Long id) {
        return exerciseMuscleRepository.findById(id);
    }

    public ExerciseMuscle saveExerciseMuscle(ExerciseMusclesRequestDTO exerciseMusclesRequestDTO) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exerciseMusclesRequestDTO.getExerciseId());
        Optional<Muscle> muscleOptional = muscleRepository.findById(exerciseMusclesRequestDTO.getMuscleId());

        if (exerciseOptional.isPresent() && muscleOptional.isPresent()) {
            ExerciseMuscle exerciseMuscle = new ExerciseMuscle();
            exerciseMuscle.setExerciseId(exerciseOptional.get());
            exerciseMuscle.setMuscleId(muscleOptional.get());

            return exerciseMuscleRepository.save(exerciseMuscle);
        } else {
            return null;
        }
    }
}

