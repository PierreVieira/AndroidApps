package com.example.school.features.students.data.dataSource.dto;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.school.features.students.domain.model.Student;

@Entity
public class StudentDto implements DtoInterface<Student> {
    @NonNull
    @PrimaryKey
    public String registration;

    @ColumnInfo(name = "note1")
    public float note1;

    @ColumnInfo(name = "note2")
    public float note2;

    @ColumnInfo(name = "note3")
    public float note3;

    @ColumnInfo(name = "name")
    public String name;

    public StudentDto(@NonNull String registration) {
        this.registration = registration;
    }

    public StudentDto(@NonNull String registration, @NonNull String name, @NonNull float[] notes) {
        this.registration = registration;
        this.name = name;
        this.note1 = notes[0];
        this.note2 = notes[1];
        this.note3 = notes[2];
    }

    @Override
    public Student toDomain() {
        float[] notes = {note1, note2, note3};
        return new Student(name, notes, registration, null);
    }
}