package com.example.booklibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.booklibrary.entity.Book;
import com.example.booklibrary.repository.BookRepository;
//@Component
@Service
public class BookService {
@Autowired
	BookRepository repository;
	public void save(Book v) {
	repository.save(v);
		
	}
public List<Book> getAllBook(){
		return repository.findAll();
	
}
	
	public Book getBookById(int id) {
		return repository.findById(id).get();
		
	}
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
