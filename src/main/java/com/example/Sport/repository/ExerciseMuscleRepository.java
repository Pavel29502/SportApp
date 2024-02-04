package com.example.Sport.repository;

import com.example.Sport.bean.ExerciseMuscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseMuscleRepository extends JpaRepository<ExerciseMuscle, Long> {
}
