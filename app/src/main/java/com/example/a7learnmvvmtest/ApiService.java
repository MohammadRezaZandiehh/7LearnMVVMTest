package com.example.a7learnmvvmtest;

import java.util.List;

import io.reactivex.Single;

import retrofit2.http.GET;

public interface ApiService {
    @GET("experts/student")
    Single<List<Student>> getStudents();
}