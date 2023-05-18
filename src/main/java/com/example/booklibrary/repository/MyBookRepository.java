package com.example.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booklibrary.entity.MyBookList;

@Repository

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
