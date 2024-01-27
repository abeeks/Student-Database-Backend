package com.abeeks.studentdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity //Marks a Java class as a JPA (Java Persistence API) entity. Represents a table in a relational database.
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //primary ID for the student that is automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String department;
}
