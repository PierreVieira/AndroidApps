package com.example.school.features.students.presentation.screens.student.editStudent;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.school.R;
import com.example.school.databinding.FragmentEditStudentBinding;
import com.example.school.features.students.domain.model.Student;
import com.example.school.features.students.presentation.screens.student.StudentBaseFragment;

public class EditStudentFragment extends StudentBaseFragment {

    private FragmentEditStudentBinding binding;
    private EditStudentViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditStudentBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(EditStudentViewModel.class);
        setupStudentObserver();
        setupAddButton();
        return binding.getRoot();
    }

    private void setupAddButton() {
        binding.upsertStudentButton.setOnClickListener(v -> {
                Editable name, registration, note1, note2, note3;
                name = binding.nameEditText.getText();
                registration = binding.registrationEditText.getText();
                note1 = binding.note1EditText.getText();
                note2 = binding.note2EditText.getText();
                note3 = binding.note3EditText.getText();
                if (viewModel.invalidNameField(name)) {
                    if (viewModel.isBlank(name)) {
                        showInvalidFieldToast(R.string.invalid_name_blank);
                    } else {
                        showInvalidFieldToast(R.string.invalid_name);
                    }
                } else if (viewModel.invalidRegistrationField(registration)) {
                    if (viewModel.isBlank(registration)) {
                        showInvalidFieldToast(R.string.invalid_registration_blank);
                    } else {
                        showInvalidFieldToast(R.string.invalid_registration);
                    }
                } else if (viewModel.invalidNoteField(note1)) {
                    if (viewModel.isBlank(note1)) {
                        showInvalidFieldToast(R.string.invalid_note1_blank);
                    } else {
                        showInvalidFieldToast(R.string.invalid_note1);
                    }
                } else if (viewModel.invalidNoteField(note2)) {
                    if (viewModel.isBlank(note2)) {
                        showInvalidFieldToast(R.string.invalid_note2_blank);
                    } else {
                        showInvalidFieldToast(R.string.invalid_note2);
                    }
                } else if (viewModel.invalidNoteField(note3)) {
                    if (viewModel.isBlank(note3)) {
                        showInvalidFieldToast(R.string.invalid_note3_blank);
                    } else {
                        showInvalidFieldToast(R.string.invalid_note3);
                    }
                } else {
                    Student student = viewModel.convertFieldsToStudent(name, registration, note1, note2, note3);
                    sharedViewModel.setAddedStudent(student);
                    viewModel.upsertStudent(student);
                    findNavController().navigateUp();
                }
            }
        );
    }

    private void showInvalidFieldToast(@StringRes int messageResourceId) {
        Toast.makeText(requireContext(), messageResourceId, Toast.LENGTH_SHORT).show();
    }

    private void setupStudentObserver() {
        Observer<Student> studentObserver = student -> {
            binding.loading.setVisibility(View.GONE);
            if (student == null) {
                binding.upsertStudentButton.setText(R.string.add_student);
            } else {
                float[] notes = student.getNotes();
                binding.note1EditText.setText(
                    sharedViewModel.getConvertFloatNoteToStringUseCase().invoke(notes[0])
                );
                binding.note2EditText.setText(
                    sharedViewModel.getConvertFloatNoteToStringUseCase().invoke(notes[1])
                );
                binding.note3EditText.setText(
                    sharedViewModel.getConvertFloatNoteToStringUseCase().invoke(notes[2])
                );
                binding.registrationEditText.setText(student.getRegistration());
                binding.registrationEditText.setEnabled(false);
                binding.nameEditText.setText(student.getName());
                binding.upsertStudentButton.setText(R.string.edit_student);
            }
        };
        LiveData<Student> currentStudent = sharedViewModel.getCurrentStudent();
        currentStudent.observe(getViewLifecycleOwner(), studentObserver);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_exit_app) {
            findNavController().navigate(R.id.action_editStudentFragment_to_loginFragment);
            return true;
        }
        return false;
    }
}