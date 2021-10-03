package com.example.a7learnmvvmtest;

import android.content.Intent;

import androidx.lifecycle.LiveData;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
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

    public Single<Student> save(String firstName, String lastName, String course, String score) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstName", firstName);
        jsonObject.addProperty("lastName", lastName);
        jsonObject.addProperty("course", course);
        jsonObject.addProperty("score", Integer.parseInt(score));

        return apiService.saveStudent(jsonObject).doOnSuccess(student -> studentDao.addStudent(student));        // vaghti ye object e student dorost kardi
        // khate bala : dar baghe miad aval to method e save api gharar mide , badesh agar in kar movaghiat amiz bod , (doOnSuccess) , miad va too database ham save mikone . (ba dastoor e studentDao.addStudent(student))
    }
}
