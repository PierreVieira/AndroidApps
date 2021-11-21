package com.example.school.features.students.presentation.screens.student;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.school.R;
import com.example.school.features.students.domain.useCases.ConvertFloatNoteToStringUseCase;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class StudentBaseFragment extends Fragment {

    protected SharedViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.student_menu, menu);
    }

    protected NavController findNavController() {
        return NavHostFragment.findNavController(this);
    }
}
