package com.example.Sport.service;


//import com.example.Sport.bean.TrainingExercise;
//import com.example.Sport.repository.TrainingExerciseRepository;
import com.example.Sport.bean.Exercise;
import com.example.Sport.bean.Training;
import com.example.Sport.bean.TrainingExercise;
import com.example.Sport.dto.TrainingExerciseRequestDTO;
import com.example.Sport.repository.ExerciseRepository;
import com.example.Sport.repository.TrainingExerciseRepository;
import com.example.Sport.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingExerciseService {

//    private final TrainingExerciseRepository trainingExerciseRepository;
//
//    public TrainingExerciseService(TrainingExerciseRepository repository) {
//        this.trainingExerciseRepository = repository;
//    }
//
//    public List<TrainingExercise> getAllTrainingExercisses() {
//        return trainingExerciseRepository.findAll();
//    }
//
//    public Optional<TrainingExercise> getTrainingExerciseById(Long id) {
//        return trainingExerciseRepository.findById(id);
//    }
//
//    public TrainingExercise saveTrainingExercise(TrainingExercise trainingExercise) {
//        return trainingExerciseRepository.save(trainingExercise);
//    }
//
//    public TrainingExercise updateTrainingExercise(TrainingExercise trainingExercise) {
//        return trainingExerciseRepository.save(trainingExercise);
//    }
//
//    public void deleteTrainingExerciseById(Long id) {
//        trainingExerciseRepository.deleteById(id);
//    }
        private final TrainingExerciseRepository trainingExerciseRepository;
        private final TrainingRepository trainingRepository;
        private final ExerciseRepository exerciseRepository;

        @Autowired
        public TrainingExerciseService(TrainingExerciseRepository trainingExerciseRepository,
                                       TrainingRepository trainingRepository,
                                       ExerciseRepository exerciseRepository) {
            this.trainingExerciseRepository = trainingExerciseRepository;
            this.trainingRepository = trainingRepository;
            this.exerciseRepository = exerciseRepository;
        }

        public List<TrainingExercise> getAllTrainingExercises() {
            return trainingExerciseRepository.findAll();
        }

        public Optional<TrainingExercise> getTrainingExerciseById(Long id) {
            return trainingExerciseRepository.findById(id);
        }
        public TrainingExercise saveTrainingExercise(TrainingExerciseRequestDTO trainingExerciseRequestDTO) {
        TrainingExercise trainingExercise = new TrainingExercise();

//            проверка, существует ли тренировка с указанным id
            Training training = trainingRepository.findById(trainingExerciseRequestDTO.getTrainingId())
                    .orElseThrow(() -> new EntityNotFoundException("Training not found whith id" +
                            trainingExerciseRequestDTO.getTrainingId()));

            Exercise exercise =exerciseRepository.findById(trainingExerciseRequestDTO.getExerciseId())
                    .orElseThrow(() -> new EntityNotFoundException("Exercise not found with id: " +
                            trainingExerciseRequestDTO.getExerciseId()));
            //установка связи с тренировкой
            trainingExercise.setTraining(training);
            trainingExercise.setExercise(exercise);
            trainingExercise.setApproach(trainingExerciseRequestDTO.getApproach());
            trainingExercise.setPriority(trainingExerciseRequestDTO.getPriority());
            return trainingExerciseRepository.save(trainingExercise);

        }

}


//
//        public TrainingExercise updateTrainingExercise(Long id, TrainingExerciseDTO updatedTrainingExerciseDTO) {
//            TrainingExercise existingTrainingExercise = trainingExerciseRepository.findById(id)
//                    .orElseThrow(() -> new EntityNotFoundException("TrainingExercise not found with id: " + id));
//
//            // Проверяем, существует ли тренировка с указанным id
//            Training training = trainingRepository.findById(updatedTrainingExerciseDTO.getTrainingId())
//                    .orElseThrow(() -> new EntityNotFoundException("Training not found with id: " + updatedTrainingExerciseDTO.getTrainingId()));
//            existingTrainingExercise.setTraining(training);
//
//            // Проверяем, существует ли упражнение с указанным id
//            Exercise exercise = exerciseRepository.findById(updatedTrainingExerciseDTO.getExerciseId())
//                    .orElseThrow(() -> new EntityNotFoundException("Exercise not found with id: " + updatedTrainingExerciseDTO.getExerciseId()));
//            existingTrainingExercise.setExercise(exercise);
//
//            existingTrainingExercise.setApproach(updatedTrainingExerciseDTO.getApproach());
//            existingTrainingExercise.setPriority(updatedTrainingExerciseDTO.getPriority());
//
//            return trainingExerciseRepository.save(existingTrainingExercise);
//        }
//    }



