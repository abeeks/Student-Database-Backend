package com.abeeks.studentdatabase.repository;

import com.abeeks.studentdatabase.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRespository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
