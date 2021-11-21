package com.example.school.features.students.domain.useCases.editStudent.validFields;

import android.text.Editable;

import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BaseValidateUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BlankOrNullFieldUseCase;

import java.util.Locale;

import javax.inject.Inject;

public class RegistrationIsValidUseCase extends BaseValidateUseCase {

    @Inject
    public RegistrationIsValidUseCase(BlankOrNullFieldUseCase blankOrNullFieldUseCase) {
        super(blankOrNullFieldUseCase);
    }

    @Override
    protected Boolean execute(Editable editable) {
        if (super.invoke(editable)) {
            String permitted = "0123456789.";
            String registrationString = editable.toString();
            for (int i = 0; i < registrationString.length(); i++) {
                if (!permitted.contains(String.format(Locale.ROOT, "%c", registrationString.charAt(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
