package com.example.Sport.controller;

import com.example.Sport.bean.TypeTraining;
import com.example.Sport.service.TypeTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeTrainingController {

    private final TypeTrainingService service;

    @Autowired
    public TypeTrainingController(TypeTrainingService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeTraining> getAllTypeTrainings() {
        return service.getAllTypeTrainings();
    }

    @GetMapping("/{id}")
    public TypeTraining getTypeTrainingById(@PathVariable Long id) {
        return service.getTypeTrainingById(id);
    }

    @PostMapping("/save")
    public void saveTypeTraining(@RequestBody TypeTraining typeTraining) {
        service.save(typeTraining);
    }

    @PutMapping("/update")
    public void updateTypeTraining(@RequestBody TypeTraining typeTraining) {
        service.update(typeTraining);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeTraining(@PathVariable Long id) {
        service.delete(id);
    }
}