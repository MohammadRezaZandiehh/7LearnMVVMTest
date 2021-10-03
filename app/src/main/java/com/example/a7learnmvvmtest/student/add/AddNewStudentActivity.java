package com.example.a7learnmvvmtest.student.add;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7learnmvvmtest.ApiServiceProvider;
import com.example.a7learnmvvmtest.AppDatabase;
import com.example.a7learnmvvmtest.MainViewModel;
import com.example.a7learnmvvmtest.MyViewModelFactory;
import com.example.a7learnmvvmtest.R;
import com.example.a7learnmvvmtest.StudentRepository;
import com.google.android.material.textfield.TextInputEditText;

import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddNewStudentActivity extends AppCompatActivity {
    //    private static final String TAG = "AddNewStudentFormActivi";
    private Disposable disposable;
//    private AddNewStudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        AddNewStudentViewModel addNewStudentViewModel = new ViewModelProvider(this, new MyViewModelFactory(new StudentRepository(ApiServiceProvider.getApiService(), AppDatabase.getInstance(getApplicationContext()).studentDao())))
                .get(AddNewStudentViewModel.class);


        Toolbar toolbar = findViewById(R.id.toolbar_addNewStudent);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_white_24dp);

        final TextInputEditText firstNameEt = findViewById(R.id.et_addNewStudent_firstName);
        final TextInputEditText lastNameEt = findViewById(R.id.et_addNewStudent_lastName);
        final TextInputEditText courseEt = findViewById(R.id.et_addNewStudent_course);
        final TextInputEditText scoreEt = findViewById(R.id.et_addNewStudent_score);

        View saveBtn = findViewById(R.id.fab_addNewStudent_save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstNameEt.length() > 0 &&
                        lastNameEt.length() > 0 &&
                        courseEt.length() > 0 &&
                        scoreEt.length() > 0) {

                    addNewStudentViewModel.save(firstNameEt.getText().toString(),
                            lastNameEt.getText().toString(),
                            courseEt.getText().toString(),
                            scoreEt.getText().toString()).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new CompletableObserver() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {
                                    disposable = d;
                                }

                                @Override
                                public void onComplete() {
                                    finish();
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }
                            });

                }
            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
