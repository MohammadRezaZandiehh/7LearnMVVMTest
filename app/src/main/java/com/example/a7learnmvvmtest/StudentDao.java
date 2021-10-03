package com.example.a7learnmvvmtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    //read
    @Query("SELECT * FROM students ORDER BY mId DESC")
    LiveData<List<Student>> getStudents();

    //save
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStudents(List<Student> students);

    //save                                                                                              // in save i hast k vaghti dar addNewStudent hastim va ye object e student ro por mikonim , dar mikhaym dar database mmon zakhire she .
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStudent(Student student);
}

