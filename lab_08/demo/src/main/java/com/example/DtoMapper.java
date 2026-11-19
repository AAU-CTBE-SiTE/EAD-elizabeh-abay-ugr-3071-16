package com.example;

public class DtoMapper {
    static StudentDTO toStudentDTO(Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getEmail(),
                student.getDepartement());
    }

}
