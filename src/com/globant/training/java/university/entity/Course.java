package com.globant.training.java.university.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String courseName;
	private int classroom;
	private List<Student> registeredStudents = new ArrayList<Student>();
	private Teacher assignedTeacher;
	
	public Course(String name, int classroom, List<Student> students, Teacher teacher) {
		this.courseName = name;
		this.classroom = classroom;
		this.registeredStudents = students;
		this.assignedTeacher = teacher;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public List<Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(List<Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

	public Teacher getAssignedTeacher() {
		return assignedTeacher;
	}

	public void setAssignedTeacher(Teacher assignedTeacher) {
		this.assignedTeacher = assignedTeacher;
	}
	
}
