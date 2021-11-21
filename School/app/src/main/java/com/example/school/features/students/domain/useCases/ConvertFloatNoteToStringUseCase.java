package com.example.school.features.students.domain.useCases;

import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface1;

import java.util.Locale;

public class ConvertFloatNoteToStringUseCase implements UseCaseInterface1<Float, String> {
    @Override
    public String invoke(Float note) {
        return String.format(Locale.ROOT, "%.2f", note);
    }
}
