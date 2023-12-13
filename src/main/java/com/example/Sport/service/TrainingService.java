package com.example.Sport.service;


//import com.example.Sport.bean.Training;
//import com.example.Sport.repository.TrainingRepository;
import com.example.Sport.bean.Body;
import com.example.Sport.bean.Training;
import com.example.Sport.bean.TypeTraining;
import com.example.Sport.bean.User;
import com.example.Sport.dto.TrainingRequestDTO;
import com.example.Sport.repository.TrainingRepository;
import com.example.Sport.repository.TypeTrainingRepository;
import com.example.Sport.repository.UserRepository;
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
        User user = userRepository.findById(trainingDTO.getUserId()).orElse(null);
        TypeTraining typeTraining = typeTrainingRepository.findById(trainingDTO.getTypeTrainingId()).orElse(null);

        Training training = new Training();
        training.setUser(user);
        training.setTypeTraining(typeTraining);
        training.setTitle(trainingDTO.getTitle());
        training.setDescription(trainingDTO.getDescription());
        training.setTime(trainingDTO.getTime());
        training.setTrainingBody(Body.getById(trainingDTO.getBody()));

        return trainingRepository.save(training);
    }

    public Training updateTraining(Training training) {
        return trainingRepository.save(training);
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}


