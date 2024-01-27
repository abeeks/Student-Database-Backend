package com.abeeks.studentdatabase.service;

import com.abeeks.studentdatabase.exception.StudentAlreadyExistException;
import com.abeeks.studentdatabase.exception.StudentNotFoundException;
import com.abeeks.studentdatabase.model.Student;
import com.abeeks.studentdatabase.repository.StudentRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
//The StudentService class is responsible for providing business logic and operations related to the management of student entities

public class StudentService implements IStudentService{
    private final StudentRespository studentRespository;
    // Retrieve all students
    @Override
    public List<Student> getStudents() {
        return studentRespository.findAll();
    }
    //Add a new student
    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistException(student.getEmail() + " already exists");
        }

        return studentRespository.save(student);
    }
    //Update an existing student by ID
    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRespository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRespository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found."));
    }
    //Retrieve a specific student by ID
    @Override
    public Student getStudentById(Long id) {
        return studentRespository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found with ID:" + id));
    }
    //Delete a student by ID
    @Override
    public void deleteStudent(Long id) {
        if(!studentRespository.existsById(id)){
            throw new StudentNotFoundException("Sorry, this student could not be found.");
        }
        studentRespository.deleteById(id);
    }
    //Check if a student with the given email already exists
    private boolean studentAlreadyExists(String email) {
        return studentRespository.findByEmail(email).isPresent();
    }

}
