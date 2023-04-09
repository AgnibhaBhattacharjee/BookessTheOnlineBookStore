package com.spring.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.User;

@Repository
public class UserDao {
	@Autowired
	private SessionFactory factory;
//	@Autowired
//	EntityManager em;
	
	public List<User> getAllUsers()
	{
		Session session = factory.openSession();
		List<User> users = session.createQuery("from User", User.class).getResultList();
		session.close();
		return users;
	}
	public boolean loginUser(LoginDTO dto) throws Exception
	{
		System.out.println(dto);
		Session session = factory.openSession();
		User user = session.get(User.class, dto.getEmail());
		System.out.println(user);
		if(user != null)
		{
			if(dto.getPassword().equals(user.getPassword()))
				return true;
		}
		throw new Exception("Invalid Credentials");
	}
	
	public void createUser(User user){
		Session session = factory.openSession();
//		User newUser = session.load(User.class, user.getEmail());
//		if(newUser!=null){
//			throw new RuntimeException("User already exists with this email id");
//		}
		Transaction transaction= session.beginTransaction();
		try{
			System.out.println(user.toString());
			session.save(user);
			transaction.commit();
			session.close();
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage()+"User already exists with this email id");
		}
		
	}
	public User getUser(String email){
		try{
			Session session= factory.openSession();
			User user= session.get(User.class, email);
			session.close();
			return user;
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage()+"User not available with this email id= "+email);
		}
	}
	public void addToLovedBooks(String email,int bookId){
		try{
			Session session= factory.openSession();
			User updateUser= session.get(User.class, email);
			Book book= session.get(Book.class, bookId);
			List<Book> lovedBooks=updateUser.getLovedBooks();
			lovedBooks.add(book);
			lovedBooks.forEach(e->System.out.println(e));
			Transaction transaction= session.beginTransaction();
			session.update(updateUser);
			transaction.commit();
			session.close();
			
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
		
	}
	public void addToReadLaterBooks(String email,int bookId){
		try{
			Session session= factory.openSession();
			User updateUser= session.get(User.class, email);
			Book book= session.get(Book.class, bookId);
			List<Book> readLaterBooks=updateUser.getReadLaterBooks();
			readLaterBooks.add(book);
			readLaterBooks.forEach(e->System.out.println(e));
			Transaction transaction= session.beginTransaction();
			session.update(updateUser);
			transaction.commit();
			session.close();
			
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
		
	}
	public List<Book> getLovedBooksByUser(String email){
		try{
			System.out.println("Inside getLovedBooksByUser Dao");
			Session session= factory.openSession();
			User updateUser= session.get(User.class, email);
			System.out.println(updateUser.toString());
			List<Book> lovedBooks= new ArrayList<Book>();
			updateUser.getLovedBooks().forEach(e->lovedBooks.add(e));
			updateUser.getLovedBooks().forEach(e-> System.out.println(e));
			session.close();
			return lovedBooks;
			
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Book> getReadLaterBooksByUser(String email){
		try{
			System.out.println("Inside getReadLaterBooksByUser Dao");
			Session session= factory.openSession();
			User updateUser= session.get(User.class, email);
			System.out.println(updateUser.toString());
			List<Book> readLaterBooks= new ArrayList<Book>();
			updateUser.getReadLaterBooks().forEach(e-> readLaterBooks.add(e));
			readLaterBooks.forEach(e-> System.out.println(e));
			
			session.close();
			return readLaterBooks;
			
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
	}
	public void removeFromLovedBooks(String email, int bookId) {
		// TODO Auto-generated method stub
		try{
			Session session= factory.openSession();
			User updateUser= session.get(User.class, email);
			Book book= session.get(Book.class, bookId);
			List<Book> lovedBooks=updateUser.getLovedBooks();
			lovedBooks.remove(book);
			updateUser.setLovedBooks(lovedBooks);
			updateUser.getLovedBooks().forEach(e->System.out.println(e));
			Transaction transaction= session.beginTransaction();
			session.update(updateUser);
			transaction.commit();
			session.close();
			
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
		
	}
	public void removeFromReadLaterBooks(String email, int bookId) {
		// TODO Auto-generated method stub
		try{
			Session session= factory.openSession();
			Transaction transaction= session.beginTransaction();
			User updateUser= session.get(User.class, email);
			Book book= session.get(Book.class, bookId);
			List<Book> readLaterBooks=updateUser.getReadLaterBooks();
			readLaterBooks.forEach(e->System.out.println(e));
			String sql= "delete from user_read_later_books where email = :userEmail and book_id= :id";
			Query query= session.createNativeQuery(sql);
			query.setParameter("userEmail", updateUser.getEmail());
			query.setParameter("id", book.getId());
			query.executeUpdate();
//			session.createNativeQuery("delete from user_read_later_books where email = :userEmail and book_id= :id")
//			.setParameter("userEmail", updateUser.getEmail()).setParameter("id", book.getId()).executeUpdate();
			readLaterBooks.remove(book);
			readLaterBooks.forEach(e->System.out.println(e));
			updateUser.setLovedBooks(readLaterBooks);
			updateUser.getReadLaterBooks().forEach(e->System.out.println(e));
			
			session.update(updateUser);
			transaction.commit();
			session.close();
			
		}catch(RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
