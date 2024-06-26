package com.Project.springboot.BaseClasses;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@JsonIgnoreProperties({"user", "activityLogs"}) // Add "activityLogs" to the list

public class Dog {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dogID;

    @Setter
    @Getter
    @Column(nullable = false, length = 255)
    private String name;

    @Setter
    @Getter
    @Column(nullable = true, length = 255)
    private String imageURL;

    @Setter
    @Getter
    @Column(nullable = false, length = 255)
    private Integer weight;

    @Setter
    @Getter
    @Column(nullable = false, length = 255)
    private Integer age;

    @Setter
    @Getter
    @Column(name = "breed_name", nullable = false, length = 255)
    private String breedName;

    @Setter
    @Getter
    @Column(nullable = false, length = 255)
    private Float height;

    // User relationship
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
//    @JsonBackReference
    private User user;


    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActivityLog> activityLogs;

//    // Breed relationship
//    @ManyToOne
//    @JoinColumn(name = "breedID", nullable = false)
//    private Breed breed;


}
