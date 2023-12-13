package com.example.Sport.repository;

import com.example.Sport.bean.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Long> {
}
