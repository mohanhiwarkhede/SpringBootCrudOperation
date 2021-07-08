package com.mgh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgh.entity.Book;
import com.mgh.service.BookServiceImpl;

@RestController

public class BookController {
	@Autowired	
	BookServiceImpl bs;
	
	
	  @GetMapping("/books")
	  
	  public ResponseEntity<List<Book>> getBooks() {
		  return new ResponseEntity<List<Book>>(bs.getAllBooks(),HttpStatus.OK);
		  }
	 
	
@PostMapping("/addBook")
public ResponseEntity<Book> addBook(@RequestBody Book bk) {
	
	return new ResponseEntity<Book>(bs.addBook(bk),HttpStatus.ACCEPTED);
	
}

@GetMapping("/book/{id}")
public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") int id) {
	System.out.println("Inside get Book Method");
	
return 	new ResponseEntity<Optional<Book>>(bs.findBookById(id),HttpStatus.ACCEPTED);
	
}
	@DeleteMapping("/delete/{id}")
	public void deleteBk(@PathVariable("id") int id) {
		bs.deleteBook(id);
	}
	
	@PutMapping("/update/{id}")
	public List<Book> updateBook(@RequestBody Book bk,@PathVariable("id") int id) {
		
		
		return bs.updateBook(bk,id);
	}
	
}
