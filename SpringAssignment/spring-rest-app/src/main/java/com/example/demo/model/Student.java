package com.example.demo.model;

public class Student {

	
	
	private String name;
	private String school ;
	long rollNo;
	double percentage;
	int standard ;
	
	
	
	public Student(String name, String school, long rollNo, double percentage, int standard) {
		
		this.name = name;
		this.school = school;
		this.rollNo = rollNo;
		this.percentage = percentage;
		this.standard = standard;
		
		StudentService.StudentList.add(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	
	
}
