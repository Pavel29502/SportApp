package com.example.Sport.service;

import com.example.Sport.bean.Muscle;
import com.example.Sport.repository.MuscleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MuscleService {

    private final MuscleRepository muscleRepository;

    public MuscleService(MuscleRepository repository) {
        this.muscleRepository = repository;
    }

    public List<Muscle> getAllMuscles() {
        return muscleRepository.findAll();
    }

    public Optional<Muscle> getMuscleById(Long id) {
        return muscleRepository.findById(id);
    }

    public Muscle saveMuscle(Muscle muscle) {
        return muscleRepository.save(muscle);
    }

    public Muscle updateMuscle(Muscle muscle) {
        return muscleRepository.save(muscle);
    }

    public void deleteMuscle(Long id) {
        muscleRepository.deleteById(id);
    }



}
