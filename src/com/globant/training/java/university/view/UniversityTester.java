package com.globant.training.java.university.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.globant.training.java.university.entity.*;

public class UniversityTester {

	public static void main(String[] args) {
		
		University globant = new University();
		
		Teacher teacher1 = new FullTimeTeacher("Leif Nagell", 5000, 34);
		Teacher teacher2 = new FullTimeTeacher("Ted Skjellum", 5000, 33);
		Teacher teacher3 = new PartTimeTeacher("Carl-Michael Eide", 2500, 25);
		Teacher teacher4 = new PartTimeTeacher("Rune Eriksen", 2000, 20);
		
		Collections.addAll(globant.getTeachers(), teacher1, teacher2, teacher3, teacher4);
		
		Student student1 = new Student("John Dederle", 1030528144, 35);
		Student student2 = new Student("Julian Bautista", 80235789, 36);
		Student student3 = new Student("Rodolfo Arevalo", 75578953, 41);
		Student student4 = new Student("Jonathan Rodriguez", 81345678, 37);
		Student student5 = new Student("William Restrepo", 1035678321, 31);
		Student student6 = new Student("Camilo Rodriguez", 1038207496, 33);
		
		Collections.addAll(globant.getStudents(), student1, student2, student3, student4, student5, student6);
		
		List<Student> registeredCourse1 = new ArrayList<Student>();
		List<Student> registeredCourse2 = new ArrayList<Student>();
		List<Student> registeredCourse3 = new ArrayList<Student>();
		List<Student> registeredCourse4 = new ArrayList<Student>();
		
		Collections.addAll(registeredCourse1, student1, student2, student3, student4);
		Collections.addAll(registeredCourse2, student1, student2, student4, student5);
		Collections.addAll(registeredCourse3, student1, student3, student5, student6);
		Collections.addAll(registeredCourse4, student1, student2, student4, student5);
		
		Course course1 = new Course("Music Fundamentals", 101, registeredCourse1, teacher1);
		Course course2 = new Course("Music Techniques", 102, registeredCourse2, teacher2);
		Course course3 = new Course("Instruments", 103, registeredCourse3, teacher3);
		Course course4 = new Course("Production", 104, registeredCourse4, teacher4);
		
		Collections.addAll(globant.getCourses(), course1, course2, course3, course4);
		
		int option;
		Scanner entry = new Scanner(System.in);
		
		System.out.println("Welcome to Globant Conservatory!");
		
		do {
			System.out.println("\nWhat would you like to do?");
			System.out.println("0 - Exit");
			System.out.println("1 - List teachers");
			System.out.println("2 - List courses");
			System.out.println("3 - Create new student");
			System.out.println("4 - Create new course");
			System.out.println("5 - List student's courses");
			System.out.print("Press the option number in the menu and then enter: ");
			option = entry.nextInt();
			entry.nextLine();
			
			switch(option) {
				case 0:
					System.out.println("\nThanks for using Globant Conservatory!");
					break;
				case 1:
					System.out.println("\nTeacher Name - Salary");
					listTeachers(globant.getTeachers());
					break;
				case 2:
					int subOption;
					do {
						System.out.println("\nThese are the current courses registered:");
						listCourses(globant.getCourses());
						System.out.print("Enter the course number for details or press 0 to go back to the previous menu: ");
						subOption = entry.nextInt();
						entry.nextLine();
						if(subOption != 0) {
							try {
								listCourseDetails(globant.getCourses(), subOption);
							} catch (InputMismatchException | IndexOutOfBoundsException e) {
								System.out.println("\nInvalid course number");
							}
						}
					} while(subOption != 0);
					break;
				case 3:
					String studentName = null;
					int studentId = 0;
					int studentAge = 0;
					System.out.print("\nPlease enter the student's ID: ");
					studentId = entry.nextInt();
					entry.nextLine();
					if(studentId > 0) {
						Student createdStudent = new Student(studentName, studentId, studentAge);
						if(findStudent(globant.getStudents(), studentId)) {
							System.out.println("The student already exists. Do you wish to add him/her to another course, yes(Y) or no(N)?");
							String addToCourse = entry.nextLine();
							if(addToCourse.equals("Y")) {
								do {
									System.out.println("");
									listCourses(globant.getCourses());
									System.out.print("Enter the course number to add the student to or press 0 to go back to the previous menu: ");
									subOption = entry.nextInt();
									entry.nextLine();
									if(subOption != 0) {
										Course chosenCourse = globant.getCourses().get(subOption - 1);
										if(!findStudent(chosenCourse.getRegisteredStudents(), studentId)) {
											addStudentToCourse(globant.getCourses(), subOption, createdStudent);
											System.out.println("\nThe student was registered successfully to the course " + chosenCourse.getCourseName());
										} else {
											System.out.println("\nThe student is already registered to the chosen course");
										}
									}
								} while(subOption != 0);
							} else {
								System.out.println("\nThanks for using Globant Conservatory!");
							}
						} else {
							System.out.print("\nPlease enter the student's name: ");
							studentName = entry.nextLine();
							if(studentName != null || !studentName.equals("")) {
								System.out.print("Please enter the student's age: ");
								studentAge = entry.nextInt();
								if(studentAge >= 15) {
									createdStudent = new Student(studentName, studentId, studentAge);
									globant.addStudent(createdStudent);
									System.out.println("\nStudent created succesfully!");
									do {
										System.out.println("");
										listCourses(globant.getCourses());
										System.out.print("Enter the course number to add the student to or press 0 to go back to the previous menu: ");
										subOption = entry.nextInt();
										entry.nextLine();
										if(subOption != 0) {
											Course chosenCourse = globant.getCourses().get(subOption - 1);
											if(!findStudent(chosenCourse.getRegisteredStudents(), studentId)) {
												addStudentToCourse(globant.getCourses(), subOption, createdStudent);
												System.out.println("\nThe student was registered successfully to the course " + chosenCourse.getCourseName());
											} else {
												System.out.println("\nThe student is already registered to the chosen course");
											}
										}
									} while(subOption != 0);
								} else {
									System.out.println("Please enter a valid age");
								}
							} else {
								System.out.println("Please enter a valid name");
							}
						}
					} else {
						System.out.println("Please enter a valid ID");
					}
					break;
				case 4:
					String courseName;
					int classroomNumber;
					Teacher assignedTeacher;
					List<Student> studentsToRegister = new ArrayList<Student>();
					System.out.print("\nPlease enter the course name: ");
					courseName = entry.nextLine();
					if(courseName != null || !courseName.equals("")) {
						System.out.print("\nPlease enter the classroom number: ");
						classroomNumber = entry.nextInt();
						entry.nextLine();
						if(classroomNumber > 0) {
							System.out.println("\nTeacher Name - Salary");
							listTeachers(globant.getTeachers());
							System.out.print("Enter the teacher number to register to the course: ");
							subOption = entry.nextInt();
							entry.nextLine();
							assignedTeacher = globant.getTeachers().get(subOption - 1);
							if(assignedTeacher != null) {
								Course addedCourse = new Course(courseName, classroomNumber, studentsToRegister, assignedTeacher);
								do {
									System.out.println("");
									listStudents(globant.getStudents());
									System.out.print("Enter the student ID to add to the course or press 0 to go back to the previous menu: ");
									studentId = entry.nextInt();
									entry.nextLine();
									if(studentId != 0) {
										if(findStudent(globant.getStudents(), studentId)) {
											if(!findStudent(addedCourse.getRegisteredStudents(), studentId)) {
												Student studentToRegister = getStudent(globant.getStudents(), studentId);
												addedCourse.getRegisteredStudents().add(studentToRegister);
												System.out.println("\nThe student was registered successfully to the course " + addedCourse.getCourseName());
											} else {
												System.out.println("\nThe student is already registered to the chosen course");
											}
										} else {
											System.out.println("\nThe student does not exist");
										}
									} else {
										break;
									}
								} while(subOption != 0);
								globant.addCourse(addedCourse);
								System.out.println("\nThe course " + addedCourse.getCourseName() + " was registered successfully!");
							} else {
								System.out.println("\nInvalid teacher number");
							}
						} else {
							System.out.println("\nInvalid classroom number");
						}
					} else {
						System.out.println("\nInvalid course name");
					}
					break;
				case 5:
					System.out.print("\nPlease enter the student ID: ");
					studentId = entry.nextInt();
					entry.nextLine();
					Course searchedCourse;
					List<String> foundCourses = new ArrayList<String>();
					for(int i = 0; i < globant.getCourses().size(); i++) {
						searchedCourse = globant.getCourses().get(i);
						if(findStudent(searchedCourse.getRegisteredStudents(), studentId)) {
							foundCourses.add(searchedCourse.getCourseName());
						}
					}
					if(foundCourses.size() != 0) {
						System.out.println("These are the courses the student is registered to:");
						for(String name:foundCourses) {
							System.out.println(name);
						}
					} else {
						System.out.println("\nThe student is not registered in any of the courses");
					}
					break;
				default:
					System.out.println("\nInvalid option, please try again\n");
			}
		} while(option != 0);
	}
	
	public static void listTeachers(List<Teacher> teacherList) {
		int index = 1;
		for(Teacher teacher:teacherList) {
			System.out.println((index++) + " - " + teacher.getTeacherName() + " - $" + teacher.calculateSalary(teacher.getSalary()));
		}
	}
	
	public static void listStudents(List<Student> studentList) {
		System.out.println("Student Name - Student ID - Student Age");
		for(Student student:studentList) {
			System.out.println(student.getStudentName() + " - " + student.getId() + " - " + student.getAge());
		}
	}
	
	public static boolean findStudent(List<Student> studentList, int id) {
		boolean studentExists = false;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getId() == id) {
				studentExists = true;
			}
		}
		
		return studentExists;
	}
	
	public static Student getStudent(List<Student> studentList, int id) {
		Student foundStudent = new Student(null, 0, 0);
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getId() == id) {
				foundStudent = studentList.get(i);
			}
		}
		return foundStudent;
	}
	
	public static void listCourses(List<Course> courseList) {
		for(int i = 0; i < courseList.size(); i++) {
			System.out.println(i + 1 + " - " + courseList.get(i).getCourseName());
		}
	}
	
	public static void listCourseDetails(List<Course> courseList, int courseIndex) {
		Course chosenCourse = courseList.get(courseIndex - 1);
		System.out.println("\nCourse Name: " + chosenCourse.getCourseName());
		System.out.println("Classroom: " + chosenCourse.getClassroom());
		System.out.println("Assigned Teacher: " + chosenCourse.getAssignedTeacher().getTeacherName());
		System.out.println("Registered Students: ");
		listStudents(chosenCourse.getRegisteredStudents());
	}
	
	public static void addStudentToCourse(List<Course> courseList, int courseIndex, Student addedStudent) {
		Course chosenCourse = courseList.get(courseIndex - 1);
		chosenCourse.getRegisteredStudents().add(addedStudent);
	}

}
