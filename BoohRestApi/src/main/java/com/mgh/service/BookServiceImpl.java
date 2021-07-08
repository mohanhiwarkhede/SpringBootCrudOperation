package com.mgh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mgh.entity.Book;
import com.mgh.repository.BookRepository;



@Component
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository br;
	
	public static List<Book> list= new ArrayList<Book>();

	/*
	 * static {
	 * 
	 * list.add(new Book("abc",123,"xyz")); list.add(new Book("sdf",222,"mno"));
	 * list.add(new Book("def",333,"pqr"));
	 * 
	 * }
	 */
	public Book addBook(Book bk) {		
		br.save(bk);
		 
		
		 return bk;
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return br.findAll();
	}
	@Override
	public Optional<Book> findBookById(int id) {
		// TODO Auto-generated method stub
		Optional<Book> bk=br.findById(id);
		return bk;
	}
	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
		list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		System.out.println("Book Deleted");
		System.out.println(list.toString());
	}
	@Override
	public List<Book> updateBook(Book bk,int id) {
		// TODO Auto-generated method stub
		/*
		 * list=list.stream().filter(book->book.getId()!=bk.getId()).collect(Collectors.
		 * toList()); list.add(bk);
		 */
		list=list.stream().map(book->{
			
			if(book.getId()==id) {
				book.setAuther(bk.getAuther());
				book.setName(bk.getName());
				
			}
			return book;
		}).collect(Collectors.toList());
		return list;
	}
	
	
}
