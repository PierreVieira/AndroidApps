package com.example.school.features.students.domain.useCases.editStudent.validFields;

import android.text.Editable;

import androidx.annotation.NonNull;

import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BaseValidateUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BlankOrNullFieldUseCase;

import java.util.Locale;

import javax.inject.Inject;

public class NoteIsValidUseCase extends BaseValidateUseCase {

    @Inject
    public NoteIsValidUseCase(BlankOrNullFieldUseCase blankOrNullFieldUseCase) {
        super(blankOrNullFieldUseCase);
    }

    @Override
    protected Boolean execute(Editable note) {
        if (super.invoke(note) && noteStringIsValid(note)) {
            String noteString = note.toString();
            String noteStringReplaced = noteString.replace(',', '.');
            float noteFloat = Float.parseFloat(noteStringReplaced);
            return !(noteFloat > 10f) && !(noteFloat < 0);
        }
        return false;
    }

    private boolean noteStringIsValid(@NonNull Editable note) {
        boolean containsNumber = false;
        String numbers = "0123456789";
        int countPointsOrColumns = 0;
        for (int i = 0; i < note.length(); ++i) {
            char currentChar = note.charAt(i);
            if (i == 0 && charIsDecimalSeparator(currentChar)) {
                return false;
            }
            if (charIsDecimalSeparator(currentChar)) {
                countPointsOrColumns++;
                if (countPointsOrColumns > 1) {
                    return false;
                }
            }
            if (!containsNumber) {
                if (numbers.contains(String.format(Locale.ROOT, "%c", currentChar))) {
                    containsNumber = true;
                }
            }
        }
        return containsNumber;
    }

    private boolean charIsDecimalSeparator(char character) {
        return character == '.' || character == ',';
    }
}
