package com.example.Sport.repository;

//import com.example.Sport.bean.TrainingExercise;
import com.example.Sport.bean.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {
    List<TrainingExercise> findByTrainingId(Long trainingId);

}
