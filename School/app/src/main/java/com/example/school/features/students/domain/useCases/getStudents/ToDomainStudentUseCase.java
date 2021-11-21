package com.example.school.features.students.domain.useCases.getStudents;

import com.example.school.features.students.data.dataSource.dto.StudentDto;
import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.GetAverageUseCase;
import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface1;

import javax.inject.Inject;

public class ToDomainStudentUseCase implements UseCaseInterface1<StudentDto, Student> {

    private final GetAverageUseCase getAverageUseCase;

    @Inject
    public ToDomainStudentUseCase(GetAverageUseCase getAverageUseCase) {
        this.getAverageUseCase = getAverageUseCase;
    }

    @Override
    public Student invoke(StudentDto studentDto) {
        float[] notes = {studentDto.note1, studentDto.note2, studentDto.note3};
        return new Student(
                studentDto.name,
                notes,
                studentDto.registration,
                getAverageUseCase.invoke(notes)
        );
    }
}
