package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StudentService {
     
	
	
	public static List<Student> StudentList = Arrays.asList(
		    new Student("Aarav", "DPS", 2021200001, 95.2, 10),
		    new Student("Vihaan", "DAV", 2021200002, 88.7, 9),
		    new Student("Ishaan", "St. Xavier's", 2021200003, 72.3, 8),
		    new Student("Ananya", "DPS", 2021200004, 85.6, 7),
		    new Student("Kavya", "DAV", 2021200005, 67.4, 6),
		    new Student("Rohan", "DPS", 2021200006, 92.5, 11),
		    new Student("Aditya", "St. Xavier's", 2021200007, 90.1, 10),
		    new Student("Sneha", "DAV", 2021200008, 78.9, 9),
		    new Student("Tanish", "DPS", 2021200009, 81.0, 8),
		    new Student("Ritika", "DAV", 2021200010, 65.3, 7),
		    new Student("Manav", "St. Xavier's", 2021200011, 88.4, 6),
		    new Student("Pooja", "DPS", 2021200012, 91.6, 5),
		    new Student("Rahul", "DAV", 2021200013, 73.2, 4),
		    new Student("Meera", "DPS", 2021200014, 79.5, 3),
		    new Student("Sarvesh", "DPS", 2021200015, 91.5, 11),
		    new Student("Sarthak", "St. Xavier's", 2021200016, 89.7, 10),
		    new Student("Niharika", "DAV", 2021200017, 86.3, 9),
		    new Student("Aditi", "DPS", 2021200018, 68.5, 8),
		    new Student("Saurabh", "DAV", 2021200019, 83.1, 7),
		    new Student("Rashmi", "St. Xavier's", 2021200020, 76.2, 6),
		    new Student("Dev", "DPS", 2021200021, 97.8, 5),
		    new Student("Sanya", "DAV", 2021200022, 62.4, 4),
		    new Student("Neeraj", "St. Xavier's", 2021200023, 74.9, 3),
		    new Student("Tanisha", "DPS", 2021200024, 69.7, 2),
		    new Student("Abhishek", "DAV", 2021200025, 84.6, 1),
		    new Student("Pranav", "DPS", 2021200026, 90.5, 11),
		    new Student("Aarohi", "St. Xavier's", 2021200027, 82.1, 10),
		    new Student("Aryan", "DAV", 2021200028, 79.8, 9),
		    new Student("Diya", "DPS", 2021200029, 93.4, 8),
		    new Student("Yash", "DAV", 2021200030, 75.6, 7),
		    new Student("Mahima", "St. Xavier's", 2021200031, 88.2, 6),
		    new Student("Om", "DPS", 2021200032, 92.9, 5),
		    new Student("Rishi", "DAV", 2021200033, 77.3, 4),
		    new Student("Shruti", "St. Xavier's", 2021200034, 70.8, 3),
		    new Student("Aakash", "DPS", 2021200035, 85.1, 2),
		    new Student("Bhavya", "DAV", 2021200036, 81.4, 1),
		    new Student("Vivek", "DPS", 2021200037, 79.0, 11),
		    new Student("Sakshi", "St. Xavier's", 2021200038, 87.2, 10),
		    new Student("Manisha", "DAV", 2021200039, 80.5, 9),
		    new Student("Kunal", "DPS", 2021200040, 91.3, 8),
		    new Student("Ritika", "DAV", 2021200041, 67.9, 7),
		    new Student("Ujjwal", "St. Xavier's", 2021200042, 73.4, 6),
		    new Student("Gauri", "DPS", 2021200043, 78.8, 5),
		    new Student("Harsh", "DAV", 2021200044, 82.9, 4),
		    new Student("Vidhi", "St. Xavier's", 2021200045, 90.6, 3),
		    new Student("Ishita", "DPS", 2021200046, 89.5, 2),
		    new Student("Aman", "DAV", 2021200047, 85.0, 1),
		    new Student("Priyansh", "DPS", 2021200048, 76.2, 11),
		    new Student("Divya", "St. Xavier's", 2021200049, 92.1, 10),
		    new Student("Siddharth", "DAV", 2021200050, 94.7, 9)
		);
	
	
	
	
	
	   public static Student getStudentByRollNo(int rollNo) {
	        return StudentList.stream()
	                .filter(s -> s.getRollNo() == rollNo)
	                .findFirst()
	                .orElse(null);
	    }
	   

	    public static List<Student> getStudentsBySchool(String school) {
	        return StudentList.stream()
	                .filter(s -> s.getSchool().equalsIgnoreCase(school))
	                .collect(Collectors.toList());
	    }

	    public static List<Student> getStudentsByResult(boolean pass) {
	        return StudentList.stream()
	                .filter(s -> pass ? s.getPercentage() >= 40 : s.getPercentage() < 40)
	                .collect(Collectors.toList());
	    }

	    public static long countStudentsByStandard(int standard) {
	        return StudentList.stream()
	                .filter(s -> s.getStandard() == standard)
	                .count();
	    }

	    public static long getTotalStrength(String school) {
	        return StudentList.stream()
	                .filter(s -> s.getSchool().equalsIgnoreCase(school))
	                .count();
	    }

	    public static List<Student> getToppers() {
	        return StudentList.stream()
	                .sorted((s1, s2) -> Double.compare(s2.getPercentage(), s1.getPercentage()))
	                .limit(5)
	                .collect(Collectors.toList());
	    }

	    public static  Student getTopperByStandard(int standard) {
	        return StudentList.stream()
	                .filter(s -> s.getStandard() == standard)
	                .max(Comparator.comparingDouble(Student::getPercentage))
	                .orElse(null);
	    }
	   
	
}