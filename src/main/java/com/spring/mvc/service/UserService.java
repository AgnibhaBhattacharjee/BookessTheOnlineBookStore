package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao database;
	
	public boolean validateUser(LoginDTO dto) throws Exception
	{
		if(this.database.loginUser(dto))
			return true;
		return false;
	}
	public List<String> getAllUsersEmail()
	{
		List<User> users = this.database.getAllUsers();
		List<String> useremail = new ArrayList<String>();
		users.forEach(user -> useremail.add(user.getEmail()));
		return useremail;
	}
	
	public void insertUser(User user){
		database.createUser(user);
	}
	
	public void addToLovedBooks(String email, int bookId){
		database.addToLovedBooks(email, bookId);
	}
	
	public void addToReadLaterBooks(String email, int bookId){
		database.addToReadLaterBooks(email, bookId);
	}
	
	public List<Book> getLovedBooksByUser(String email){
		System.out.println("Inside getLovedBooksByUser Service");
		return database.getLovedBooksByUser(email);
	}
	
	public List<Book> getReadLaterBooksByUser(String email){
		System.out.println("Inside getReadLaterBooksByUser Service");
		return database.getReadLaterBooksByUser(email);
	}
	
	public User getUserByEmail(String email){
		return database.getUser(email);
	}
	public void removeFromLovedBooks(String email, int bookId) {
		// TODO Auto-generated method stub
		System.out.println("Inside removeFromLovedBooks Service");
		database.removeFromLovedBooks(email, bookId);
		
	}
	public void removeFromReadLaterBooks(String email, int bookId) {
		// TODO Auto-generated method stub
		System.out.println("Inside removeFromReadLaterBooks Service");
		database.removeFromReadLaterBooks(email, bookId);
		
	}

}
