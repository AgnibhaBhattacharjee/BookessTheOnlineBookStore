package com.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/register")
	public String registerUser(){
		return "register";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		System.out.println(user.toString());
		//request.
		userService.insertUser(user);
		//request.setAttribute("mode", "MODE_HOME");
		return "redirect:index.jsp";
	}

}
