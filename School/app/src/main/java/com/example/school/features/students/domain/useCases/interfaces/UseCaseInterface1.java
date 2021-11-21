package com.example.school.features.students.domain.useCases.interfaces;

public interface UseCaseInterface1<Argument, Return> {
    Return invoke(Argument argument);
}