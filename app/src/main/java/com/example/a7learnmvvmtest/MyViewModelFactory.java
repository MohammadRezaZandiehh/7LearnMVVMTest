package com.example.a7learnmvvmtest;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7learnmvvmtest.student.add.AddNewStudentViewModel;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    private StudentRepository repository;

    public MyViewModelFactory(StudentRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(repository);
        else if (modelClass.isAssignableFrom(AddNewStudentViewModel.class))
            return (T) new AddNewStudentViewModel(repository);
        else
            throw new IllegalArgumentException("viewModel is not valied");
    }
}
