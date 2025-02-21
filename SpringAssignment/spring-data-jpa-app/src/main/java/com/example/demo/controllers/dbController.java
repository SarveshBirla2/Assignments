package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Student;
import com.example.demo.repos.db1repo;
import com.example.demo.repos2.db2repo;

import jakarta.transaction.Transactional;


@RestController
public class dbController {
     
	@Autowired
	db1repo db1;
	
	@Autowired
	db2repo db2;
	
	@Transactional
	@PostMapping("/student")
	  public String addEmployees(@RequestBody Student s)
	  {    
	    db1.save(s);
	    db2.save(s);
	    
	    return "Student added succesfully"; 
		
	  }
	
}
