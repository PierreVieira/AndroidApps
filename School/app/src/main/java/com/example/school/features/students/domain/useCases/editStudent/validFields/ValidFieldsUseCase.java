package com.example.school.features.students.domain.useCases.editStudent.validFields;

import android.text.Editable;

import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BlankOrNullFieldUseCase;

import javax.inject.Inject;

public class ValidFieldsUseCase {

    private final NoteIsValidUseCase noteIsValidUseCase;
    private final NameFieldIsValidUseCase nameFieldIsValidUseCase;
    private final BlankOrNullFieldUseCase blankOrNullFieldUseCase;
    private final RegistrationIsValidUseCase registrationIsValidUseCase;

    @Inject
    public ValidFieldsUseCase(
        NameFieldIsValidUseCase nameFieldIsValidUseCase,
        NoteIsValidUseCase noteIsValidUseCase,
        BlankOrNullFieldUseCase blankOrNullFieldUseCase,
        RegistrationIsValidUseCase registrationIsValidUseCase
    ) {
        this.nameFieldIsValidUseCase = nameFieldIsValidUseCase;
        this.blankOrNullFieldUseCase = blankOrNullFieldUseCase;
        this.noteIsValidUseCase = noteIsValidUseCase;
        this.registrationIsValidUseCase = registrationIsValidUseCase;
    }

    public boolean noteIsValid(Editable editableNote) {
        return noteIsValidUseCase.execute(editableNote);
    }

    public boolean registrationIsValid(Editable editableRegistration) {
        return registrationIsValidUseCase.execute(editableRegistration);
    }

    public boolean nameIsValid(Editable editableName) {
        return nameFieldIsValidUseCase.execute(editableName);
    }

    public boolean isBlank(Editable editable) {
        return blankOrNullFieldUseCase.invoke(editable);
    }
}
