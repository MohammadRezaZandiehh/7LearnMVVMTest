package com.example.a7learnmvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.a7learnmvvmtest.student.add.AddNewStudentActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainViewModel mainViewModel = new ViewModelProvider(this, new MyViewModelFactory(new StudentRepository(ApiServiceProvider.getApiService(), AppDatabase.getInstance(getApplicationContext()).studentDao())))
                .get(MainViewModel.class);
        mainViewModel.getStudents().observe(this, students -> {
            RecyclerView recyclerView = findViewById(R.id.rv_main_students);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(studentAdapter);

        });


        mainViewModel.getError().observe(this, error -> {
            Log.e("MainActivity", "Error: " + error);
        });

        mainViewModel.getProgressIndicator().observe(this, mustShow -> {
            findViewById(R.id.progressBarMain).setVisibility(mustShow ? View.VISIBLE : View.GONE);
        });

        findViewById(R.id.fab_main_addNewStudent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNewStudentActivity.class));
            }
        });

    }
}