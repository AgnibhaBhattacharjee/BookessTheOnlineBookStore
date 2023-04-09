package com.spring.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.User;
import com.spring.mvc.service.BookService;
import com.spring.mvc.service.UserService;

@Controller
public class BooksController {
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	
	@GetMapping("/books")
	public String bookPage(Map<String, List<Book>> map)
	{	System.out.println("Inside Books Controller");
		map.put("books", this.bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/lovedbooks")
	public String lovedBookPage(Map<String, List<Book>>  map, HttpSession session){
		System.out.println("Inside Loved Books Controller");
		String email= (String) session.getAttribute("email");
		System.out.println(email);
		//User user= userService.getUserByEmail(email);
		map.put("lovedBooks",userService.getLovedBooksByUser(email) );
		return "lovedBooks";
	}
	
	@GetMapping("/readlaterbooks")
	public String readLaterBookPage(Map<String, List<Book>>  map, HttpSession session){
		System.out.println("Inside Loved Books Controller");
		String email= (String) session.getAttribute("email");
		//User user= userService.getUserByEmail(email);
		System.out.println(email);
		map.put("readLaterBooks",userService.getReadLaterBooksByUser(email));
		return "readLaterBooks";
	}

}
