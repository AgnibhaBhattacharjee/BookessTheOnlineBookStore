package com.spring.mvc.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="user_name")
	private String userName;
	@ManyToMany
	@JoinTable(name="user_read_later_books", joinColumns=@JoinColumn(name="email"), inverseJoinColumns=@JoinColumn(name="book_id"))
	private List<Book> readLaterBooks;
	@ManyToMany
	@JoinTable(name="user_loved_books", joinColumns=@JoinColumn(name="email"), inverseJoinColumns=@JoinColumn(name="book_id"))
	private List<Book> lovedBooks;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password, String userName, List<Book> readLaterBooks, List<Book> lovedBooks) {
		super();
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.readLaterBooks = readLaterBooks;
		this.lovedBooks = lovedBooks;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Book> getReadLaterBooks() {
		return readLaterBooks;
	}

	public void setReadLaterBooks(List<Book> readLaterBooks) {
		this.readLaterBooks = readLaterBooks;
	}

	public List<Book> getLovedBooks() {
		return lovedBooks;
	}

	public void setLovedBooks(List<Book> lovedBooks) {
		this.lovedBooks = lovedBooks;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", userName=" + userName + ", readLaterBooks="
				+ readLaterBooks + ", lovedBooks=" + lovedBooks + "]";
	}

	
	

}
