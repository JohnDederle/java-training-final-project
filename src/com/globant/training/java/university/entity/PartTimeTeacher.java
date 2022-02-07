package com.globant.training.java.university.entity;

public class PartTimeTeacher extends Teacher {
	
	private int activeWeeklyHours;
	
	public PartTimeTeacher(String name, double salary, int weeklyHours) {
		super(name, salary);
		this.activeWeeklyHours = weeklyHours;
	}
	
	public int getActiveWeeklyHours() {
		return activeWeeklyHours;
	}
	
	public void setActiveWeeklyHours(int activeWeeklyHours) {
		this.activeWeeklyHours = activeWeeklyHours;
	}
	
	public double calculateSalary(double salary) {
		return salary * this.activeWeeklyHours;
	}
	
}
