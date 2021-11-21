package com.example.school.di;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.school.features.students.data.dataSource.StudentsDatabase;
import com.example.school.features.students.data.repository.StudentsRepositoryImpl;
import com.example.school.features.students.domain.repository.StudentsRepository;
import com.example.school.features.students.domain.useCases.ConvertFloatNoteToStringUseCase;
import com.example.school.features.students.domain.useCases.GetAverageUseCase;
import com.example.school.features.students.domain.useCases.UpsertInRamUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.RegistrationIsValidUseCase;
import com.example.school.features.students.domain.useCases.editStudent.validFields.base.BlankOrNullFieldUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class StudentsModule {

    @Provides
    @Singleton
    public StudentsRepository provideStudentsRepository(@NonNull StudentsDatabase db) {
        return new StudentsRepositoryImpl(db.studentDao());
    }

    @Provides
    @Singleton
    public GetAverageUseCase provideGetStudentAverageUseCase() {
        return new GetAverageUseCase();
    }

    @Provides
    @Singleton
    public ConvertFloatNoteToStringUseCase provideConvertFloatNoteToStringUseCase() {
        return new ConvertFloatNoteToStringUseCase();
    }

    @Provides
    @Singleton
    public UpsertInRamUseCase provideUpsertInRamUseCase() {
        return new UpsertInRamUseCase();
    }

    @Provides
    @Singleton
    public BlankOrNullFieldUseCase provideBlankOrNullFieldUseCase() {
        return new BlankOrNullFieldUseCase();
    }

    @Provides
    @Singleton
    public RegistrationIsValidUseCase provideRegistrationIsValidUseCase(BlankOrNullFieldUseCase blankOrNullFieldUseCase) {
        return new RegistrationIsValidUseCase(blankOrNullFieldUseCase);
    }

    @Provides
    @Singleton
    public StudentsDatabase provideStudentsDatabase(Application app) {
        return Room
            .databaseBuilder(
                app,
                StudentsDatabase.class,
                StudentsDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries()
            .build();
    }
}
