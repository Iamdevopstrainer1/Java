package com.example.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booklibrary.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
