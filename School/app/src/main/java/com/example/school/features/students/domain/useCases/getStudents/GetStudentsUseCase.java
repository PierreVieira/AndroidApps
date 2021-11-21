package com.example.school.features.students.domain.useCases.getStudents;

import androidx.annotation.NonNull;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.repository.StudentsRepository;
import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class GetStudentsUseCase implements UseCaseInterface<List<Student>> {

    private final StudentsRepository repository;
    private final ToDomainStudentUseCase toDomainStudentUseCase;

    @Inject
    public GetStudentsUseCase(StudentsRepository repository, ToDomainStudentUseCase toDomainStudentUseCase) {
        this.repository = repository;
        this.toDomainStudentUseCase = toDomainStudentUseCase;
    }

    @NonNull
    @Override
    public ArrayList<Student> invoke() {
        List<Student> studentsMapped = repository
                .getStudents()
                .stream()
                .map(toDomainStudentUseCase::invoke)
                .collect(Collectors.toList());
        return (ArrayList<Student>) studentsMapped;
    }
}
