package com.example.Sport.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "body")
    private String body;

    @ManyToMany(mappedBy = "muscles")
    private Set<Exercise> exercises;

    @Enumerated(EnumType.STRING)
//    @Column(name = "body")
//    private String muscleBody;
    private Body muscleBody;
////////////
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;


}
