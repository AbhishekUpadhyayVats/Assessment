package com.example.book_service.consumerservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.book_service.repository.BookRepository;
import com.example.book_service.service.BookService;
import com.example.book_service.sharedDto.OrderMessage;

@Service
public class BookMessageListener {

    private final BookRepository bookRepository;

	@Autowired
	private BookService service;

    BookMessageListener(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	@RabbitListener(queues = "message-queue")
	public void receiveOrder(OrderMessage message) {
		System.err.println("Received Order Message");
		
		if(message.getAction().equals("CREATE")) {
			service.reduceStock(message.getBookId(), message.getQuantity());
		}
		else if(message.getAction().equals("CANCEL")){
			service.increaseStock(message.getBookId(),message.getQuantity());
		}
	}
}
