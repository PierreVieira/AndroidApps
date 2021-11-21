package com.example.school.features.students.presentation.screens.student.studentList;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.UpsertInRamUseCase;
import com.example.school.features.students.domain.useCases.getStudents.GetStudentsUseCase;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class StudentsListViewModel extends ViewModel {

    private final GetStudentsUseCase getStudentsUseCase;
    private final UpsertInRamUseCase upsertInRamUseCase;
    private ArrayList<Student> studentsCache;

    @Inject
    public StudentsListViewModel(
        GetStudentsUseCase getStudentsUseCase,
        UpsertInRamUseCase upsertInRamUseCase
    ) {
        this.getStudentsUseCase = getStudentsUseCase;
        this.upsertInRamUseCase = upsertInRamUseCase;
    }

    public ArrayList<Student> getStudents() {
        if (studentsCache == null) {
            studentsCache = getStudentsUseCase.invoke();
        }
        return studentsCache;
    }

    @Nullable
    public Student getDefaultStudent() {
        return null;
    }

    public void insertInCache(Student student) {
        upsertInRamUseCase.invoke(studentsCache, student);
    }

    public UpsertInRamUseCase getUpsertInRamUseCase() {
        return upsertInRamUseCase;
    }
}