package com.globant.training.java.university.entity;

public class FullTimeTeacher extends Teacher {
	
	private int experienceYears;
	
	public FullTimeTeacher(String name, double salary, int experience) {
		super(name, salary);
		this.experienceYears = experience;
	}
	
	public int getExperienceYears() {
		return experienceYears;
	}
	
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	public double calculateSalary(double salary) {
		return salary * this.experienceYears;
	}
	
}
