package com.mgh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
public class Book {

	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", Auther=" + author + "]";
	}
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	private Author author;
	
	
		public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

		public Book(String name, int id, Author auther) {
		super();
		this.name = name;
		this.id = id;
		this.author = auther;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Author getAuther() {
		return author;
	}
	public void setAuther(Author auther) {
		author = auther;
	}

	
}
