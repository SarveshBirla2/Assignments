package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController
public class ParameterTypes {
    
	@GetMapping("/query")
	public String queryParamDemo(@RequestParam("user")String name , int age) {
		System.out.println("*****Query Parameter******");
		System.out.println(" Name : "+name);
		System.out.println(" Age : "+age);
		return "Welcome !"+name+" .You are "+age+" years old.";
		
	}
	
	@GetMapping("/query/{name}/{age}")
	public String pathParamDemo(@PathVariable String name , @PathVariable int age) {
		System.out.println("*****Path Parameter******");
		System.out.println(" Name : "+name);
		System.out.println(" Age : "+age);
		return "Welcome !"+name+" .You are "+age+" years old.";
		
	}
	
	@GetMapping("/body")
	public String bodyParamDemo(@RequestBody Person p) {
		System.out.println("*****Body Parameter******");
		System.out.println(" Name : "+p.getName());
		System.out.println(" Age : "+p.getAge());
		return "Welcome !"+p.getName()+" .You are "+p.getAge()+" years old.";
		
	}
	
	@GetMapping(path="/persons",produces="application/json")
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("Pooja",25));
		list.add(new Person("Amit",26));
		list.add(new Person("Joseph",29));
		list.add(new Person("Omkar",31));
		list.add(new Person("Sujatha",21));
		
		return list;
		
	}
}
