package com.example.school.features.students.domain.useCases.editStudent;

import com.example.school.features.students.data.dataSource.dto.StudentDto;
import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.repository.StudentsRepository;
import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterfaceVoidWithArgument;

import javax.inject.Inject;

public class UpsertStudentUseCase implements UseCaseInterfaceVoidWithArgument<Student> {
    private final StudentsRepository repository;

    @Inject
    UpsertStudentUseCase(StudentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void invoke(Student student) {
        StudentDto studentDto = new StudentDto(
                student.getRegistration(),
                student.getName(),
                student.getNotes()
        );
        repository.upsertStudent(studentDto);
    }
}
