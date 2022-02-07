package com.globant.training.java.university.entity;

public class Student {
	
	private String studentName;
	private int id;
	private int age;
	
	public Student(String name, int id, int age) {
		this.studentName = name;
		this.id = id;
		this.age = age;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
