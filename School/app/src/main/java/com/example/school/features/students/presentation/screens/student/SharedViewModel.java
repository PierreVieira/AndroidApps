package com.example.school.features.students.presentation.screens.student;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.ConvertFloatNoteToStringUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Student> currentStudent = new MutableLiveData<>();
    private final MutableLiveData<Student> addedStudent = new MutableLiveData<>();
    private final ConvertFloatNoteToStringUseCase convertFloatNoteToStringUseCase;

    @Inject
    public SharedViewModel(ConvertFloatNoteToStringUseCase convertFloatNoteToStringUseCase) {
        this.convertFloatNoteToStringUseCase = convertFloatNoteToStringUseCase;
    }

    public void setCurrentStudent(@Nullable Student student) {
        currentStudent.setValue(student);
    }
    public void setAddedStudent(@Nullable Student student) {
        addedStudent.setValue(student);
    }

    public LiveData<Student> getCurrentStudent() {
        return currentStudent;
    }

    public MutableLiveData<Student> getAddedStudent() {
        return addedStudent;
    }

    public ConvertFloatNoteToStringUseCase getConvertFloatNoteToStringUseCase() {
        return convertFloatNoteToStringUseCase;
    }
}
