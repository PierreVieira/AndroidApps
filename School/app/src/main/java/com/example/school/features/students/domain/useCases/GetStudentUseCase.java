package com.example.school.features.students.domain.useCases;

import androidx.annotation.NonNull;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.repository.StudentsRepository;
import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface1;

import javax.inject.Inject;

public class GetStudentUseCase implements UseCaseInterface1<String, Student> {
    private final StudentsRepository repository;

    @Inject
    public GetStudentUseCase(StudentsRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public Student invoke(String registration) {
        return repository
                .getStudentByRegistration(registration)
                .toDomain();
    }
}
