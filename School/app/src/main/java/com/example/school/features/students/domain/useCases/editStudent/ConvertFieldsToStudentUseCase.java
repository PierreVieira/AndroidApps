package com.example.school.features.students.domain.useCases.editStudent;

import android.text.Editable;

import androidx.annotation.NonNull;

import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.GetAverageUseCase;
import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface5;

import java.util.Objects;

import javax.inject.Inject;

public class ConvertFieldsToStudentUseCase
    implements UseCaseInterface5<Editable, Editable, Editable, Editable, Editable, Student> {

    private final GetAverageUseCase getAverageUseCase;

    @Inject
    public ConvertFieldsToStudentUseCase(GetAverageUseCase getAverageUseCase) {
        this.getAverageUseCase = getAverageUseCase;
    }

    @Override
    public Student invoke(
        @NonNull Editable editableName,
        @NonNull Editable editableRegistration,
        @NonNull Editable editableN1,
        @NonNull Editable editableN2,
        @NonNull Editable editableN3
    ) {
        String name, registration;
        float[] notes;
        float note1, note2, note3;
        name = toString(editableName);
        registration = toString(editableRegistration);
        note1 = toFloat(editableN1);
        note2 = toFloat(editableN2);
        note3 = toFloat(editableN3);
        notes = new float[]{note1, note2, note3};

        return new Student(name, notes, registration, getAverageUseCase.invoke(notes));
    }

    private float toFloat(@NonNull Editable editable) {
        return Float.parseFloat(Objects.requireNonNull(editable).toString().replace(",", ".").trim());
    }

    private String toString(@NonNull Editable editable) {
        return Objects.requireNonNull(editable).toString().trim();
    }
}