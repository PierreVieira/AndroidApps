package com.example.school.features.students.domain.useCases.editStudent.validFields.base;

import android.text.Editable;

import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface1;

import javax.inject.Inject;

public abstract class BaseValidateUseCase implements UseCaseInterface1<Editable, Boolean> {

    BlankOrNullFieldUseCase blankOrNullFieldUseCase;

    public BaseValidateUseCase(BlankOrNullFieldUseCase blankOrNullFieldUseCase) {
        this.blankOrNullFieldUseCase = blankOrNullFieldUseCase;
    }

    protected abstract Boolean execute(Editable editable);

    @Override
    public Boolean invoke(Editable editable) {
        return !blankOrNullFieldUseCase.invoke(editable);
    }
}
