package com.example.school.features.students.domain.useCases.editStudent.validFields.base;

import android.text.Editable;

import java.util.Locale;

import javax.inject.Inject;

public class OnlyAlphabetCharsUseCase extends BaseValidateUseCase{

    @Inject
    public OnlyAlphabetCharsUseCase(BlankOrNullFieldUseCase blankOrNullFieldUseCase) {
        super(blankOrNullFieldUseCase);
    }

    @Override
    protected Boolean execute(Editable editable) {
        String text = editable.toString();
        String lettersLower = "abcdefghijklmnopqrstuvwxyz";
        String lettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < text.length(); i++) {
            String currentChar = String.format(Locale.ROOT, "%c", text.charAt(i));
            if (!lettersLower.contains(currentChar) || !lettersUpper.contains(currentChar)) {
                return false;
            }
        }
        return true;
    }
}
