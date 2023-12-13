package com.example.Sport.repository;

import com.example.Sport.bean.TypeTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeTrainingRepository extends JpaRepository<TypeTraining, Long> {
}
