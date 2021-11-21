package com.example.school.features.students.presentation.screens.student.studentList.adapter.viewHolder;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.databinding.StudentListItemBinding;
import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.domain.useCases.ConvertFloatNoteToStringUseCase;
import com.example.school.features.students.presentation.screens.student.studentList.OnCardStudentClick;

public class StudentListViewHolder extends RecyclerView.ViewHolder implements ViewHolderInterface<Student> {
    private final StudentListItemBinding binding;
    private final OnCardStudentClick onCardStudentClick;
    private final ConvertFloatNoteToStringUseCase convertFloatNoteToStringUseCase;

    public StudentListViewHolder(
            @NonNull StudentListItemBinding binding,
            OnCardStudentClick onCardStudentClick,
            ConvertFloatNoteToStringUseCase convertFloatNoteToStringUseCase
    ) {
        super(binding.getRoot());
        this.binding = binding;
        this.onCardStudentClick = onCardStudentClick;
        this.convertFloatNoteToStringUseCase = convertFloatNoteToStringUseCase;
    }

    @Override
    public void bind(Student student) {
        binding.averageNotes.setText(convertFloatNoteToStringUseCase.invoke(student.getAverage()));
        binding.studentName.setText(student.getName());
        binding.registration.setText(student.getRegistration());
        binding.studentCard.setOnClickListener(v -> onCardStudentClick.invoke(student));
    }
}
