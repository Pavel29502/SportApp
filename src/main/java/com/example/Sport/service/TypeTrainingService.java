package com.example.Sport.service;

import com.example.Sport.bean.TypeTraining;
import com.example.Sport.repository.TypeTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTrainingService {

    private final TypeTrainingRepository typeRepository;

    @Autowired
    public TypeTrainingService(TypeTrainingRepository repository) {
        this.typeRepository = repository;
    }

    public TypeTraining save (TypeTraining typeTraining) {
        return typeRepository.save(typeTraining);
    }

    public TypeTraining update(TypeTraining typeTraining) {
        return typeRepository.save(typeTraining);
    }

    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    public List<TypeTraining> getAllTypeTrainings() {
        return typeRepository.findAll();
    }

    public TypeTraining getTypeTrainingById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }
}