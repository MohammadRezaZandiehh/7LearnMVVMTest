package com.example.a7learnmvvmtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("experts/student")
    Call<List<Student>> getStudents();
}
