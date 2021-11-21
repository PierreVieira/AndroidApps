package com.example.school.features.students.domain.useCases.editStudent.validFields.base;

import android.text.Editable;

import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface1;

public class BlankOrNullFieldUseCase implements UseCaseInterface1<Editable, Boolean> {
    @Override
    public Boolean invoke(Editable editable) {
        if (editable != null) {
            return editable.toString().trim().isEmpty();
        }
        return true;
    }
}
