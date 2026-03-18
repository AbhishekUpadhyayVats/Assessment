package com.example.book_service.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book_service.entity.Book;
import com.example.book_service.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public Book saveBook(Book book) {
		return repo.save(book);
	}
	
	public List<Book> getAllBook(){
		return repo.findAll();
	}
	
	public Book getBookById(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteBookById(Long id) {
		repo.deleteById(id);
	}
	
	public Book updateBookById(Long id, Book book) {
		Book book1 = repo.findById(id).get();
		
		book1.setAuthor(book.getAuthor());
		book1.setPrice(book.getPrice());
		book1.setStock(book.getStock());
		book1.setTitle(book.getTitle());
		
		return repo.save(book1);
	}
	
	public void reduceStock(Long id, Integer quantity) {
		Book book = repo.findById(id).get();
		
		Integer stock = book.getStock();
		
		if(stock<quantity) {
			throw new RuntimeException("Not Enough Book");
		}
		
		stock = stock - quantity;
		
		book.setStock(stock);
		
		repo.save(book);
	}
	
	public void increaseStock(Long id, Integer quantity) {
		Book book = repo.findById(id).get();
		
		Integer stock = book.getStock();
		stock = stock + quantity;
		
		book.setStock(stock);
		
		repo.save(book);
	}
}
