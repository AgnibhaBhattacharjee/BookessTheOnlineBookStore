package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BookDao;
import com.spring.mvc.entity.Book;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;
	
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	
	public Book getBookById(int bookId){
		return bookDao.getBook(bookId);
	}
	
	
	public void addBook(Book book){
		bookDao.addBook(book);
	}
	
	public void updateBook(Book book){
		bookDao.updateBook(book);
	}
	
	public void deleteBook(Book book){
		bookDao.deleteBook(book);
	}
	
	

}
