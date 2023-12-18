package com.example.Sport.controller;

import com.example.Sport.bean.TypeTraining;
import com.example.Sport.dto.TypeTrainingRequestDTO;
import com.example.Sport.service.TypeTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeTrainingController {

    private final TypeTrainingService typeTrainingService;

    @Autowired
    public TypeTrainingController(TypeTrainingService service) {
        this.typeTrainingService = service;
    }

    @GetMapping
    public List<TypeTraining> getAllTypeTrainings() {
        return typeTrainingService.getAllTypeTrainings();
    }

    @GetMapping("/{id}")
    public TypeTraining getTypeTrainingById(@PathVariable Long id) {
        return typeTrainingService.getTypeTrainingById(id);
    }

    @PostMapping("/save")
    public void saveTypeTraining(@RequestBody TypeTrainingRequestDTO typeTraining) {
        typeTrainingService.save(typeTraining);
    }

    @PutMapping("/update/{id}")
    public void updateTypeTraining(@PathVariable Long id, @RequestBody TypeTrainingRequestDTO typeTraining) {
        typeTrainingService.update(id, typeTraining);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeTraining(@PathVariable Long id) {
        typeTrainingService.delete(id);
    }
}