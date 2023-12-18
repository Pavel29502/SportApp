package com.example.Sport.service;

import com.example.Sport.bean.TypeTraining;
import com.example.Sport.bean.User;
import com.example.Sport.dto.TypeTrainingRequestDTO;
import com.example.Sport.dto.UserRequestDTO;
import com.example.Sport.repository.TypeTrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTrainingService {

    private final TypeTrainingRepository typeTrainingRepository;

    @Autowired
    public TypeTrainingService(TypeTrainingRepository repository) {
        this.typeTrainingRepository = repository;
    }

    public TypeTraining getTypeTrainingById(Long id) {
        return typeTrainingRepository.findById(id).orElse(null);
    }

    public List<TypeTraining> getAllTypeTrainings() {
        return typeTrainingRepository.findAll();
    }


    public TypeTraining save (TypeTrainingRequestDTO typeTrainingRequestDTO) {
        TypeTraining typeTraining = new TypeTraining();
        typeTraining.setTitle(typeTrainingRequestDTO.getTitle());

        return typeTrainingRepository.save(typeTraining);
    }

    public TypeTraining update(Long id, TypeTrainingRequestDTO typeTrainingRequestDTO) {
        TypeTraining existTypeTraining = typeTrainingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "TypeTraining not found with id: " + id));
        if (typeTrainingRequestDTO.getTitle() != null) {
            existTypeTraining.setTitle(typeTrainingRequestDTO.getTitle());
        }
        return typeTrainingRepository.save(existTypeTraining);
    }

    public void delete(Long id) {
        typeTrainingRepository.deleteById(id);
    }
}