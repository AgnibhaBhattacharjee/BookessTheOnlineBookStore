package com.spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.User;

@Repository
public class BookDao {
	@Autowired
	private SessionFactory factory;
	
	public List<Book> getAllBooks(){
		Session session = factory.openSession();
		List<Book> books = session.createQuery("from Book", Book.class).getResultList();
		session.close();
		return books;
	}
	
	public void addBook(Book book){
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}
	public void updateBook(Book book){
		try{
			Session session= factory.openSession();
			Transaction transaction= session.beginTransaction();
			Book updatedBook= session.get(Book.class, book.getId());
			updatedBook.setBookName(book.getBookName());
			updatedBook.setBookGenres(book.getBookGenres());
			updatedBook.setAuthorName(book.getAuthorName());
			session.update(updatedBook);
			transaction.commit();
			session.close();
		}catch(RuntimeException e){
			throw new RuntimeException("Book is not available with id= "+book.getId());
		}
		
	}
	public void deleteBook(Book book){
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		session.update(book);;
		transaction.commit();
		session.close();
	}
	public Book getBook(int bookId){
		Session session= factory.openSession();
		Book book=session.get(Book.class, bookId);
		if(book==null){
			throw new RuntimeException("Book is not available");
		}
		return book;

	}
}
