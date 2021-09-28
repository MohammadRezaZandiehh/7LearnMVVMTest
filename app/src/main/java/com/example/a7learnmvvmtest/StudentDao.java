package com.example.a7learnmvvmtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    // read
    @Query("SELECT * FROM students")
    LiveData<List<Student>> getStudents();

    //save
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStudents(List<Student> students);
}
