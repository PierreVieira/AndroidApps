package com.example.school.features.students.presentation.screens.student.studentList.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.databinding.StudentListItemBinding;
import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.ConvertFloatNoteToStringUseCase;
import com.example.school.features.students.domain.useCases.UpsertInRamUseCase;
import com.example.school.features.students.presentation.screens.student.studentList.OnCardStudentClick;
import com.example.school.features.students.presentation.screens.student.studentList.adapter.viewHolder.StudentListViewHolder;

import java.util.ArrayList;

public class StudentsListAdapter extends RecyclerView.Adapter<StudentListViewHolder> {

    private final ArrayList<Student> studentsList;
    private final OnCardStudentClick onCardStudentClick;
    private final ConvertFloatNoteToStringUseCase convertFloatNoteToStringUseCase;
    private final UpsertInRamUseCase upsertInRamUseCase;

    public StudentsListAdapter(
            ArrayList<Student> studentsList,
            OnCardStudentClick onCardStudentClick,
            ConvertFloatNoteToStringUseCase convertFloatNoteToStringUseCase,
            UpsertInRamUseCase upsertInRamUseCase
    ) {
        this.studentsList = studentsList;
        this.onCardStudentClick = onCardStudentClick;
        this.convertFloatNoteToStringUseCase = convertFloatNoteToStringUseCase;
        this.upsertInRamUseCase = upsertInRamUseCase;
    }

    public void insertStudent(Student student) {
        int indexInserted = upsertInRamUseCase.invoke(studentsList, student);
        if (indexInserted == studentsList.size() - 1) {
            notifyItemInserted(indexInserted);
        } else {
            notifyItemChanged(indexInserted);
        }
    }

    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StudentListItemBinding binding = StudentListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StudentListViewHolder(binding, onCardStudentClick, convertFloatNoteToStringUseCase);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder holder, int position) {
        holder.bind(studentsList.get(position));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }
}
