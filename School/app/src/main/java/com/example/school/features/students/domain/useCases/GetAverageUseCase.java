package com.example.school.features.students.domain.useCases;

import androidx.annotation.NonNull;

import com.example.school.features.students.domain.useCases.interfaces.UseCaseInterface1;

public class GetAverageUseCase implements UseCaseInterface1<float[], Float> {

    @NonNull
    @Override
    public Float invoke(float[] floatArray) {
        Float sum = 0f;
        int size = 0;
        for (Float number: floatArray) {
            sum += number;
            ++size;
        }
        return sum / size;
    }
}
