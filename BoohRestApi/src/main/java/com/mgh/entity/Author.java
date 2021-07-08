package com.mgh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authId;
	private String AuthName;
	@OneToOne(mappedBy= "author" )
	private Book book;
	@Override
	public String toString() {
		return "Author [authId=" + authId + ", AuthName=" + AuthName + ", book=" + book + "]";
	}
	public String getAuthName() {
		return AuthName;
	}
	public void setAuthName(String authName) {
		AuthName = authName;
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int authId, String authName,Book book) {
		super();
		this.authId = authId;
		AuthName = authName;
		this.book=book;
	}

}
