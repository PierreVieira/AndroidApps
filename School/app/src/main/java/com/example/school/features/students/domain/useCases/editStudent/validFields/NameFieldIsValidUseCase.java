package com.example.school.features.students.domain.useCases.editStudent.validFields;

import android.text.Editable;

import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BaseValidateUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BlankOrNullFieldUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.base.OnlyAlphabetCharsUseCase;

import javax.inject.Inject;

public class NameFieldIsValidUseCase extends BaseValidateUseCase {


    private final OnlyAlphabetCharsUseCase onlyAlphabetCharsUseCase;

    @Inject
    public NameFieldIsValidUseCase(
        BlankOrNullFieldUseCase blankOrNullFieldUseCase,
        OnlyAlphabetCharsUseCase onlyAlphabetCharsUseCase
    ) {
        super(blankOrNullFieldUseCase);
        this.onlyAlphabetCharsUseCase = onlyAlphabetCharsUseCase;
    }

    @Override
    protected Boolean execute(Editable editable) {
        if (!super.invoke(editable)) return false;
        return onlyAlphabetCharsUseCase.invoke(editable);
    }
}
