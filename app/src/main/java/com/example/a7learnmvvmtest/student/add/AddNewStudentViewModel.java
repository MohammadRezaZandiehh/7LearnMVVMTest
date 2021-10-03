package com.example.a7learnmvvmtest.student.add;

import androidx.lifecycle.ViewModel;
import com.example.a7learnmvvmtest.StudentRepository;
import io.reactivex.Completable;

public class AddNewStudentViewModel extends ViewModel {

    private StudentRepository studentRepository;

    public AddNewStudentViewModel(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Completable save(String firstName, String lastName, String course, String score) {
        return studentRepository.save(firstName, lastName, course, score).ignoreElement();
    }

}
