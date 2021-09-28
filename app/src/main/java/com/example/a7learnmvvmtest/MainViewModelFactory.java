package com.example.a7learnmvvmtest;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModelFactory implements ViewModelProvider.Factory {
private ApiService apiService;
    public MainViewModelFactory(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://expertdevelopers.ir/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService=retrofit.create(ApiService.class);
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(apiService);
    }
}
