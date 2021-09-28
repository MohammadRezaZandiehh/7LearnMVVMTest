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


    public void refreshStudent() {
        apiService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> students = response.body();
                studentDao.addStudents(students);
// khate bala miad listi k request zadim ba API va tahvilesh gereftim ro , miare too database va zakhirashon mikone .
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }
        });
    }


    public LiveData<List<Student>> getStudents() {
        return studentDao.getStudents();
    }
}
