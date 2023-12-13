package com.example.Sport.repository;

import com.example.Sport.bean.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
