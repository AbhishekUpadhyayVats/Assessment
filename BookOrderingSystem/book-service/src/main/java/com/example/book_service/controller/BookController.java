package com.example.book_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_service.entity.Book;
import com.example.book_service.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;

	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return service.getBookById(id);
	}
	
	@GetMapping
	public List<Book> getAllBook(){
		return service.getAllBook();
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable Long id) {
		service.deleteBookById(id);
	}
	
	@PutMapping("/{id}")
	public Book updateBookById(@PathVariable Long id, @RequestBody Book book) {
		return service.updateBookById(id, book);
	}
}
