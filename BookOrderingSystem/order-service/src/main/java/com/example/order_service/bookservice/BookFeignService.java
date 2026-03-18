package com.example.order_service.bookservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.order_service.bookdto.BookDTO;


@FeignClient(name = "BOOK-SERVICE")
public interface BookFeignService {
	
	@PostMapping("/books")
	public BookDTO saveBook(@RequestBody BookDTO book);
	
	@GetMapping("books/{id}")
	public BookDTO getBookById(@PathVariable Long id);
	
	@GetMapping("/books")
	public List<BookDTO> getAllBook();
	
	@DeleteMapping("books/{id}")
	public void deleteBookById(@PathVariable Long id);
	
	@PutMapping("books/{id}")
	public BookDTO updateBookById(@PathVariable Long id, @RequestBody BookDTO book);
}
