package com.example.school.features.students.data.dataSource;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.school.features.students.data.dataSource.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM StudentDto")
    List<StudentDto> getStudents();

    @Query("SELECT * FROM studentdto WHERE registration = :registration")
    StudentDto getStudentByRegistration(String registration);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsertStudent(StudentDto studentDto);
}
