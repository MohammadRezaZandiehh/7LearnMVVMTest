package com.example.a7learnmvvmtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private ApiService apiService;
    private MutableLiveData<List<Student>> studentLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public MainViewModel(ApiService apiService) {
        this.apiService = apiService;
        apiService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                studentLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                errorLiveData.setValue("خطای نا مشخص");
            }
        });


    }

    public LiveData<List<Student>> getStudentLiveData() {
        return studentLiveData;
    }


    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
