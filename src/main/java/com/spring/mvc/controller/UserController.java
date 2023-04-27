package com.spring.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.User;
import com.spring.mvc.service.BookService;
import com.spring.mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
	@RequestMapping("/addToLovedBooks")
	public String addToLovedBooks(@RequestParam int id, HttpSession session){
		System.out.println("inside addToLovedBooks book id="+id+"email "+session.getAttribute("email"));
		String email= (String) session.getAttribute("email");
		//User user= userService.getUserByEmail(email);
		//System.out.println(user.toString());
		//Book book= bookService.getBookById(id);
		//System.out.println(book.toString());
		userService.addToLovedBooks(email,id);
		return "redirect:lovedbooks";
	}
	
	@RequestMapping("/addToReadLaterBooks")
	public String addToReadLaterBooks(@RequestParam int id, HttpSession session){
//		System.out.println("inside addToReadLaterBooks book id="+id+"email "+session.getAttribute("email"));
		String email= (String) session.getAttribute("email");
//		User user= userService.getUserByEmail(email);
//		Book book= bookService.getBookById(id);
		userService.addToReadLaterBooks(email,id);
		return "redirect:readlaterbooks";
	}
	
	@RequestMapping("/removeFromLovedBooks")
	public String removeFromLovedBooks(@RequestParam int id, HttpSession session){
		System.out.println("inside removeFromLovedBooks book id="+id+"email "+session.getAttribute("email"));
		String email= (String) session.getAttribute("email");
		userService.removeFromLovedBooks(email,id);
		return "redirect:lovedbooks";
	}
	@RequestMapping("/removeFromReadLaterBooks")
	public String removeFromRaedLaterBooks(@RequestParam int id, HttpSession session){
		System.out.println("inside removeFromRaedLaterBooks book id="+id+ " email "+session.getAttribute("email"));
		String email= (String) session.getAttribute("email");
		userService.removeFromReadLaterBooks(email, id);
		return "redirect:readlaterbooks";
	}
	
	

}
