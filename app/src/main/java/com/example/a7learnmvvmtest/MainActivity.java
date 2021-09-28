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

        MainViewModel mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(new StudentRepository(ApiServiceProvider.getApiService(), AppDatabase.getInstance(getApplicationContext()).studentDao()))).get(MainViewModel.class);

        mainViewModel.getStudents().observe(this, students -> {
            Log.i(" MainActivity", "onCreate: ");
        });


        mainViewModel.getError().observe(this, error -> {
            Log.e("MainActivity", "Error: " + error);
        });
    }
}