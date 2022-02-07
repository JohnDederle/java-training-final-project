package com.globant.training.java.university.entity;

public abstract class Teacher {
	
	private String teacherName;
	private double salary;
	
	public Teacher(String name, double salary) {
		this.teacherName = name;
		this.salary = salary;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract double calculateSalary(double salary);
	
}
