package com.example.school.features.students.data.repository;

import com.example.school.features.students.data.dataSource.StudentDao;
import com.example.school.features.students.data.dataSource.dto.StudentDto;
import com.example.school.features.students.domain.repository.StudentsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StudentsRepositoryImpl implements StudentsRepository {

    private final StudentDao dao;

    @Inject
    public StudentsRepositoryImpl(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public List<StudentDto> getStudents() {
        return dao.getStudents();
    }

    @Override
    public StudentDto getStudentByRegistration(String registration) {
        return dao.getStudentByRegistration(registration);
    }

    @Override
    public void upsertStudent(StudentDto student) {
        dao.upsertStudent(student);
    }
}
