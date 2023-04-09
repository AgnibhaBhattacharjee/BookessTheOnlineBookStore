package com.spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_table")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private int id;
	@Column(name="book_name")
	private String bookName;
	@Column(name="book_genres")
	private String bookGenres;
	@Column(name="author_name")
	private String authorName;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String bookName, String bookGenres, String authorName) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookGenres = bookGenres;
		this.authorName = authorName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookGenres() {
		return bookGenres;
	}
	public void setBookGenres(String bookGenres) {
		this.bookGenres = bookGenres;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookGenres=" + bookGenres + ", authorName=" + authorName
				+ "]";
	}
	
	
	

}
