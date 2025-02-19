package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping(path="/",produces="text/xml")// text/plain ,text/xml 
	public String abc()
	{
		return "<html><body><h1>Welcome to REST API Apllication</h1>"
				+ "<hr></hr><h3>Thank You </h3>"
				+ "</body></html>";
	}
	
	@GetMapping("/greet")
	public String xyz(){
		return "<h2>Have a good Day :)";
	}
	
	@PostMapping("/greet")
	public String xyz2(){
		return "<h2>Have a great Day ahead :) POST ";
	}
	
	@PutMapping("/greet")
	public String xyz3(){
		return "<h2>Have a great Day ahead :) PUT";
	}
	
	@PatchMapping("/greet")
	public String xyz4(){
		return "<h2>Have a great Day ahead :) PATCH ";
	}
	
	@DeleteMapping("/greet")
	public String xyz5(){
		return "<h2>Have a great Day ahead :) DELETE ";
	}
}
