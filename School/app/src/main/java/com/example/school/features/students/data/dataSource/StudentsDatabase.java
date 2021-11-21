package com.example.school.features.students.data.dataSource;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.school.features.students.data.dataSource.dto.StudentDto;

@Database(entities = {StudentDto.class}, version = 1)
public abstract class StudentsDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "StudentsDatabase";

    public abstract StudentDao studentDao();
}
