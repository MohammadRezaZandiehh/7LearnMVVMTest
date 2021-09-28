package com.example.a7learnmvvmtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private StudentRepository repository;
    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainViewModel(StudentRepository repository) {
        this.repository = repository;
        repository.refreshStudent();
    }


    //read:
    public LiveData<List<Student>> getStudents() {
        return repository.getStudents();
    }

    public LiveData<String> getError() {
        return error;
    }
}
