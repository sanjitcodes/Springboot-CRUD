package com.learn.unitTesting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.learn.unitTesting.model.book;

@Component
public class bookService {
	private static List<book> list1 = new ArrayList<>();
	
	static {
		list1.add(new book(18, "Beating all records", "Virat Kohli", 1800));
		list1.add(new book(7, "How to Win Trophies", "MS Dhoni", 700));
		list1.add(new book(45, "Vadapao and Masti", "Rohit Sharma", 450));
	}
	
	// adding a new book
	public void addBook(book book1) {
		list1.add(book1);
	}
	
	// get all books
	public List<book> getAllBooks(){
		return list1;
	}
	
	// get book by id 
	public book getBookbyId(int id) {
		book bookFound = null;
		bookFound = list1.stream().filter(e->e.getId()==id).findFirst().get();
		return bookFound;
	}
	
	// delete book by id
	public void deleteBookById(int id) {
		list1 = list1.stream().filter(e -> (e.getId() != id) ).collect(Collectors.toList());
	}
	
	// update book by id
	public void updateBookById(book b1, int id) {
		list1 = list1.stream().map(e -> {
			if(e.getId() == id) {
				e.setName(b1.getName());
				e.setAuthor(b1.getAuthor());
				e.setPrice(b1.getPrice());
			}
			return e;
		}).collect(Collectors.toList());

	}
}
