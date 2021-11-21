package com.example.school.features.students.presentation.screens.student.editStudent;

import android.text.Editable;

import androidx.lifecycle.ViewModel;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.editStudent.ConvertFieldsToStudentUseCase;
import com.example.school.features.students.domain.useCases.editStudent.UpsertStudentUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.ValidFieldsUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class EditStudentViewModel extends ViewModel {
    private final UpsertStudentUseCase upsertStudentUseCase;
    private final ValidFieldsUseCase validFieldsUseCase;
    private final ConvertFieldsToStudentUseCase convertFieldsToStudentUseCase;

    @Inject
    public EditStudentViewModel(
        UpsertStudentUseCase upsertStudentUseCase,
        ValidFieldsUseCase validFieldsUseCase,
        ConvertFieldsToStudentUseCase convertFieldsToStudentUseCase
    ) {
        this.upsertStudentUseCase = upsertStudentUseCase;
        this.validFieldsUseCase = validFieldsUseCase;
        this.convertFieldsToStudentUseCase = convertFieldsToStudentUseCase;
    }

    public void upsertStudent(Student student) {
        upsertStudentUseCase.invoke(student);
    }

    public boolean invalidNameField(Editable editableName) {
        return !validFieldsUseCase.nameIsValid(editableName);
    }

    public boolean invalidRegistrationField(Editable editableRegistration) {
        return !validFieldsUseCase.registrationIsValid(editableRegistration);
    }

    public boolean invalidNoteField(Editable editableNote) {
        return !validFieldsUseCase.noteIsValid(editableNote);
    }

    public boolean isBlank(Editable editable) {
        return validFieldsUseCase.isBlank(editable);
    }

    public Student convertFieldsToStudent(
        Editable editableName,
        Editable editableRegistration,
        Editable editableN1,
        Editable editableN2,
        Editable editableN3
    ) {
        return convertFieldsToStudentUseCase.invoke(editableName, editableRegistration, editableN1, editableN2, editableN3);
    }
}
