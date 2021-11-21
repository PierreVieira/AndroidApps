package com.example.school.features.students.domain.useCases;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface2;

import java.util.ArrayList;

public class UpsertInRamUseCase implements UseCaseInterface2<ArrayList<Student>, Student, Integer> {

    @Override
    public Integer invoke(ArrayList<Student> students, Student student) {
        if (students.stream().anyMatch(e -> e.getRegistration().equals(student.getRegistration()))) {
            int indexToReplace = students.indexOf(student);
            students.set(indexToReplace, student);
            return indexToReplace;
        } else {
            students.add(student);
            return students.size() - 1;
        }
    }
}
