package com.mgh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgh.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
