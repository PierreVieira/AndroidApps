package com.example.school.features.students.domain.repository;

import com.example.school.features.students.data.dataSource.dto.StudentDto;

import java.util.List;

public interface StudentsRepository {
    List<StudentDto> getStudents();

    StudentDto getStudentByRegistration(String registration);

    void upsertStudent(StudentDto student);
}
