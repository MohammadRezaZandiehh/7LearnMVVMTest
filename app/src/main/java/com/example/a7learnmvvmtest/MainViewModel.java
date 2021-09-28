package com.example.a7learnmvvmtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.CompletableObserver;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends ViewModel {

    private MutableLiveData<String> error = new MutableLiveData<>();
    private StudentRepository repository;
    private Disposable disposable;

    public MainViewModel(StudentRepository repository) {

        this.repository = repository;
        repository.refreshStudents()
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        error.postValue("خطای نامشخص");
                    }
                });
    }


    //read:
    public LiveData<List<Student>> getStudents() {
        return repository.getStudents();
    }

    public LiveData<String> getError() {
        return error;
    }


    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
