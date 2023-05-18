package com.example.booklibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.booklibrary.entity.MyBookList;
import com.example.booklibrary.repository.MyBookRepository;

@Service
public class MyBookListService {

	

//	
	@Autowired
	private MyBookRepository mybook;
//	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	public List<MyBookList> getAllMyBook(){
     	return mybook.findAll();
	}
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
