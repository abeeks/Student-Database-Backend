package com.abeeks.studentdatabase.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        // Call the constructor of the superclass (RuntimeException) with the provided message
        super(message);
    }
}
