package com.example.Sport.service;

import com.example.Sport.bean.Training;
import com.example.Sport.bean.TypeTraining;
import com.example.Sport.bean.User;
import com.example.Sport.dto.TrainingRequestDTO;
import com.example.Sport.repository.TrainingRepository;
import com.example.Sport.repository.TypeTrainingRepository;
import com.example.Sport.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;
    private final TypeTrainingRepository typeTrainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, UserRepository userRepository, TypeTrainingRepository typeTrainingRepository) {
        this.trainingRepository = trainingRepository;
        this.userRepository = userRepository;
        this.typeTrainingRepository = typeTrainingRepository;
    }

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Optional<Training> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    public Training saveTraining(TrainingRequestDTO trainingDTO) {

        User user = userRepository.findById(trainingDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + trainingDTO.getUserId()));
        TypeTraining typeTraining = typeTrainingRepository.findById(trainingDTO.getTypeTrainingId())
                .orElseThrow(() -> new EntityNotFoundException("TypeTraining not found with id: " + trainingDTO.getTypeTrainingId()));

        Training training = new Training();
        training.setUser(user);
        training.setTypeTraining(typeTraining);
        training.setTitle(trainingDTO.getTitle());
        training.setDescription(trainingDTO.getDescription());
        training.setTime(trainingDTO.getTime());
//        training.setTrainingBody(Body.getById(trainingDTO.getBody()));
        training.setTrainingBody(trainingDTO.getBody());

        return trainingRepository.save(training);
    }

    public Training updateTraining(Long id, TrainingRequestDTO trainingRequestDTO) {
        Training existTraining = trainingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Training not found with id: " + id));
        if (trainingRequestDTO.getUserId() != null) {
            User user = userRepository.findById(trainingRequestDTO.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + trainingRequestDTO.getUserId()));
            existTraining.setUser(user);
        }
        if (trainingRequestDTO.getTypeTrainingId() != null) {
            TypeTraining typeTraining = typeTrainingRepository.findById(trainingRequestDTO.getTypeTrainingId())
                    .orElseThrow(() -> new EntityNotFoundException("TypeTraining not found with id "
                            + trainingRequestDTO.getTypeTrainingId()));
            existTraining.setTypeTraining(typeTraining);

        }
        if (trainingRequestDTO.getTitle() != null) {
            existTraining.setTitle(trainingRequestDTO.getTitle());
            existTraining.setDescription(trainingRequestDTO.getDescription());
            existTraining.setTime(trainingRequestDTO.getTime());
            existTraining.setTrainingBody(trainingRequestDTO.getBody());
        }
        return trainingRepository.save(existTraining);
    }
    public void delete(Long id) {
        trainingRepository.deleteById(id);
    }
}



