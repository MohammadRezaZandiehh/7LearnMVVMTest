package com.example.a7learnmvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel = new ViewModelProvider(this, new MainViewModelFactory()).get(MainViewModel.class);

        mainViewModel.getStudentLiveData().observe(this, student -> {
            Log.i("MainActivity", "onCreate: ");
        });

        mainViewModel.getErrorLiveData().observe(this, error -> {
            Log.i("MainActivity", "Error: " + error);
        });
    }
}