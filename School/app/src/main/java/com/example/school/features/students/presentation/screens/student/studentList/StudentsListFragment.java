package com.example.school.features.students.presentation.screens.student.studentList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.school.R;
import com.example.school.databinding.StudentsListFragmentBinding;
import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.presentation.screens.student.StudentBaseFragment;
import com.example.school.features.students.presentation.screens.student.studentList.adapter.StudentsListAdapter;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class StudentsListFragment extends StudentBaseFragment {

    private StudentsListViewModel viewModel;
    private StudentsListFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(StudentsListViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Context context = requireContext();
        binding = StudentsListFragmentBinding.inflate(LayoutInflater.from(context), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.loading.setVisibility(View.GONE);
        setupCurrentStudentObserver();
        setupList();
        setupFab();
    }

    private void setupCurrentStudentObserver() {
        Observer<Student> studentObserver = student -> {
            if (student != null) {
                viewModel.insertInCache(student);
                StudentsListAdapter adapter = (StudentsListAdapter) binding.studentsList.getAdapter();
                if (adapter != null) {
                    if (binding.studentsList.getVisibility() == View.GONE) {
                        noEmptyListState();
                    }
                    adapter.insertStudent(student);
                }
            }
        };
        LiveData<Student> addedStudentLiveData = sharedViewModel.getAddedStudent();
        addedStudentLiveData.observe(getViewLifecycleOwner(), studentObserver);
    }

    private void setupFab() {
        binding.fabAddStudent.setOnClickListener(v -> {
            sharedViewModel.setCurrentStudent(viewModel.getDefaultStudent());
            navigateToEditStudent();
        });
    }

    private void setupList() {
        ArrayList<Student> students = viewModel.getStudents();
        setupScreenItemsVisibility(students);
        binding.studentsList.setAdapter(
            new StudentsListAdapter(
                students,
                student -> {
                    sharedViewModel.setCurrentStudent(student);
                    navigateToEditStudent();
                },
                sharedViewModel.getConvertFloatNoteToStringUseCase(),
                viewModel.getUpsertInRamUseCase()
            )
        );
    }

    private void setupScreenItemsVisibility(ArrayList<Student> students) {
        if (students.size() > 0) {
            initialState();
        } else {
            noEmptyListState();
        }
    }

    private void initialState() {
        binding.studentsList.setVisibility(View.GONE);
        binding.emptyListMessage.setVisibility(View.VISIBLE);
    }

    private void noEmptyListState() {
        binding.studentsList.setVisibility(View.VISIBLE);
        binding.emptyListMessage.setVisibility(View.GONE);
    }

    private void navigateToEditStudent() {
        findNavController().navigate(R.id.action_studentsListFragment_to_editStudentFragment);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_exit_app) {
            findNavController().navigate(R.id.action_studentsListFragment_to_loginFragment);
            return true;
        }
        return false;
    }
}