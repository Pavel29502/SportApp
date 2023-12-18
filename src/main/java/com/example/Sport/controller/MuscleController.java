package com.example.Sport.controller;


import com.example.Sport.bean.Muscle;
import com.example.Sport.dto.MuscleRequestDTO;
import com.example.Sport.service.MuscleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muscle")
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService service) {
        this.muscleService = service;
    }

    @GetMapping
    public List<Muscle> getAllMuscles() {
        return muscleService.getAllMuscles();
    }

    @GetMapping("/{id}")
    public Muscle getMuscleById(@PathVariable Long id) {
        return muscleService.getMuscleById(id).orElse(null);
    }

    @PostMapping("/save")
    public Muscle saveMuscle(@RequestBody MuscleRequestDTO muscle) {
        return muscleService.saveMuscle(muscle);
    }
    @PutMapping("/update/{id}")
    public Muscle updateMuscle(@PathVariable Long id,@RequestBody MuscleRequestDTO muscle) {
        return muscleService.updateMuscle(id, muscle);
    }

    @DeleteMapping("/{id}")
    public void deteleMuscle(@PathVariable Long id) {
        muscleService.deleteMuscle(id);
    }

}
