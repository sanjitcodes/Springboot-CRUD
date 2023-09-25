package com.learn.unitTesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.unitTesting.model.book;
import com.learn.unitTesting.service.bookService;

@RestController
public class bookController {
	
	@Autowired
	private bookService bookService1;
	
	@GetMapping("/books")
	public List<book> getBooks() {
		return bookService1.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public book getBook(@PathVariable("id") int id) {
		return bookService1.getBookbyId(id);
	}
	
	@PostMapping("/books")
	public book addBook(@RequestBody book b1) {
		bookService1.addBook(b1);
		return b1;
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bookService1.deleteBookById(id);
	}
	
	@PutMapping("/books/{id}")
	public book updateBook(@RequestBody book b1, @PathVariable("id") int id) {
		bookService1.updateBookById(b1, id);
		return b1;
	}
	
}
