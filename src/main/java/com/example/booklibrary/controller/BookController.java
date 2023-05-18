package com.example.booklibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.booklibrary.entity.Book;
import com.example.booklibrary.entity.MyBookList;
import com.example.booklibrary.service.BookService;
import com.example.booklibrary.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	BookService service;

	@Autowired
	MyBookListService myBookService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBook();		
		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book v) {
		service.save(v);
		return "redirect:/available_books";

	}
	
	 
	@GetMapping("/my_books")
    public String getMyBooks(Model model) {	
		List<MyBookList>list=myBookService.getAllMyBook();
		model.addAttribute("book",list);
		return "myBooks";}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
      Book v=service.getBookById(id);
		MyBookList mb=new MyBookList(v.getId(),v.getName(),v.getAuthor(),v.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
		
	}

	@RequestMapping("/editBook/{id}")
	public String  editBook(@PathVariable("id")int id,Model model ){
		Book v=service.getBookById(id);
		model.addAttribute("book",v);
	return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
		public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
			return"redirect:/available_books";
	}
}
	
	

	

