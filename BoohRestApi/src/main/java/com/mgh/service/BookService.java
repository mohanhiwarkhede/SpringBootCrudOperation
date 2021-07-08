package com.mgh.service;

import java.util.List;
import java.util.Optional;

import com.mgh.entity.Book;

public interface BookService {
public Book addBook(Book bk);
public List<Book> getAllBooks();
public Optional<Book> findBookById(int id);
public void deleteBook(int id);
public List<Book> updateBook(Book bk,int id);
}
