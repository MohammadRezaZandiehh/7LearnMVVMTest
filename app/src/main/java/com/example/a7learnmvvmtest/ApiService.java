package com.example.a7learnmvvmtest;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Single;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    //read api :
    @GET("experts/student")
    Single<List<Student>> getStudents();

    //save api :
    @POST("experts/student")
    Single<Student> saveStudent(@Body JsonObject body);                                             //chon request az jens e POST gast pas ye body ham dare ...

}