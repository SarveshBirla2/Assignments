package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

//	- /students→   get all students
//	- /student/rollNo  → get specific student with given rollNo
//	- /students/school?name=DPS  → get all students of that school
//	- /students /result?pass=true/false  → all students above 40 % /below 40 %
//	- students/5/count   → how  many students in 5th standard
//	- /students/strength?school=DPS → total strength for given school name
//	- /students/ toppers      → top 5 percentage students
//	- /students/topper/3     → toppper of 3rd standard
	
	
	@GetMapping(path="/",produces="application/json")
	public List<Student> getall() {
		return StudentService.StudentList;
	}
	
	@GetMapping(path="/{rollNo}",produces="application/json")
	public Student getStudentwithRolNo(@PathVariable int rollNo) {
		 return StudentService.getStudentByRollNo(rollNo);
	}
	
	@GetMapping(path="/school",produces="application/json")
	public List<Student> getStudentbySchool(@RequestParam("name") String schoolname) {
		 return StudentService.getStudentsBySchool(schoolname);
	}
	
	@GetMapping(path="/result",produces="application/json")
	public List<Student> getStudentByResult(@RequestParam boolean pass) {
		 return StudentService.getStudentsByResult(pass);
	}
	

	@GetMapping(path="/{std}/count",produces="application/json")
	public long getStudentCountByStandard(@PathVariable int std) {
		 return StudentService.countStudentsByStandard(std);
	}
	

	@GetMapping(path="/strength",produces="application/json")
	public long getSchoolStrength(@RequestParam("school")String schoolname) {
		 return StudentService.getTotalStrength(schoolname);
	}
	
	@GetMapping(path="/toppers",produces="application/json")
	public List<Student> getToppers() {
		 return StudentService.getToppers();
	}
	

	@GetMapping(path="/topper/{std}",produces="application/json")
	public Student getTopperByStandard(@PathVariable int std) {
		 return StudentService.getTopperByStandard(std);
	}
	
	
}
