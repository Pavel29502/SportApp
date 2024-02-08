package com.example.Sport.bean;

import com.example.Sport.dto.MuscleRequestDTO;
import com.example.Sport.repository.MuscleRepository;
import com.example.Sport.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "muscle")
public class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

//    @Column(name = "body")
//    private String body;
//    delete
//    @ManyToMany(mappedBy = "muscles")
//    private Set<Exercise> exercises;

    @Enumerated(EnumType.STRING)
    @Column(name = "body")
//    private String muscleBody;
    private Body muscleBody;
////////////
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
//    @JoinColumn(name = "customer_id")
//    private User user;
}
