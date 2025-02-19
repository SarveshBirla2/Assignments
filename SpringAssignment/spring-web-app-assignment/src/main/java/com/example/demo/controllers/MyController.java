package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	
	@RequestMapping("/")
	public String getHomePage() {
		System.out.println("reaching");
		return "home.html";
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login.html";
	}
	
//	@RequestMapping("/signup")
//	public String getSignup() {
//		return "signup.html";
//	}
	
	@RequestMapping("/verify")
	public ModelAndView verifyUderMv(int customerId,String pwd,String action)
	{   System.out.println("reached verify");
	    System.out.println(action);
		ModelAndView mv = new ModelAndView();
		if(action.equals("LOGIN")) {
			
			String username=DBController.fetchName(customerId, pwd);
			if(username!=null)
			{   mv.addObject("uname",username);
				mv.setViewName("welcome.jsp");
			}
			else {
				mv.setViewName("loginFailure.jsp");
			}
		}
		if(action.equals("SIGNUP")) {
			System.out.println("reached signup");
			mv.setViewName("signup.html");
		}
		
		return mv;
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView Signup(int customerId,String pwd,String cpwd,String name) {
		ModelAndView mv = new ModelAndView();
		
		if(pwd.equals(cpwd)) {
			DBController.save(customerId, name, pwd);
			mv.addObject("uname",name);
			mv.setViewName("welcome.jsp");
		}
		else {
			mv.setViewName("passwordMismatch.jsp");
		}
		return mv;
	}
}
