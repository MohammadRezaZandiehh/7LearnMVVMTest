package com.example.a7learnmvvmtest;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Completable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentRepository {
    private ApiService apiService;
    private StudentDao studentDao;

    public StudentRepository(ApiService apiService, StudentDao studentDao) {
        this.apiService = apiService;
        this.studentDao = studentDao;
    }


    public Completable refreshStudents() {
        return apiService.getStudents().doOnSuccess(students -> studentDao.addStudents(students)).ignoreElement();
    }

    public LiveData<List<Student>> getStudents() {
        return studentDao.getStudents();
    }
}
