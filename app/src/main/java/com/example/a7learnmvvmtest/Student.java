package com.example.a7learnmvvmtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
@Entity(tableName = "students")
public class Student {

	@SerializedName("course")
	private String mCourse;
	@SerializedName("created_at")
	private String mCreatedAt;
	@SerializedName("first_name")
	private String mFirstName;
	@SerializedName("id")
	@PrimaryKey
	private Long mId;
	@SerializedName("last_name")
	private String mLastName;
	@SerializedName("score")
	private Long mScore;
	@SerializedName("updated_at")
	private String mUpdatedAt;

	public String getCourse() {
		return mCourse;
	}

	public void setCourse(String course) {
		mCourse = course;
	}

	public String getCreatedAt() {
		return mCreatedAt;
	}

	public void setCreatedAt(String createdAt) {
		mCreatedAt = createdAt;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		mId = id;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	public Long getScore() {
		return mScore;
	}

	public void setScore(Long score) {
		mScore = score;
	}

	public String getUpdatedAt() {
		return mUpdatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		mUpdatedAt = updatedAt;
	}

}
