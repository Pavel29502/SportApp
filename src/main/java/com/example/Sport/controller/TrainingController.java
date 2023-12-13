package com.example.Sport.controller;

import com.example.Sport.bean.Training;
import com.example.Sport.dto.TrainingRequestDTO;
import com.example.Sport.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public List<Training> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public Training getTrainingById(@PathVariable Long id) {
        return trainingService.getTrainingById(id).orElse(null);
    }

    @PostMapping("/save")
    public void saveTraining(@RequestBody TrainingRequestDTO training) {

        trainingService.saveTraining(training);
    }


    @PutMapping("/update")
    public void updateTraining(@RequestBody Training training) {
        trainingService.updateTraining(training);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
    }
}