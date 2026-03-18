package com.example.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.bookdto.BookDTO;
import com.example.order_service.bookservice.BookFeignService;
import com.example.order_service.entity.Order;
import com.example.order_service.producerservice.ProducerService;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.sharedDto.OrderMessage;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private BookFeignService feignService;
	
	public Order saveOrder(Order order) {
		OrderMessage orderMessage = new OrderMessage(order.getBookId(), order.getQuantity(), "CREATE");
		
		BookDTO bookDTO = feignService.getBookById(order.getBookId());
		
		order.setStatus("CREATED");
		
		order.setTotalPrice(bookDTO.getPrice()*order.getQuantity());
		
		producerService.sendOrderMessage(orderMessage);
		
		return orderRepo.save(order);
	}
	
	public Order getOrderById(Long id) {
		return orderRepo.findById(id).get();
	}
	
	public List<Order> getAllOrder(){
		return orderRepo.findAll();
	}
	
	public void deleteOrderById(Long id) {
		Order order = orderRepo.findById(id).get();
		
		OrderMessage orderMessage = new OrderMessage(order.getBookId(), order.getQuantity(), "CANCEL");
		
		producerService.sendOrderMessage(orderMessage);
		
		orderRepo.deleteById(id);
	}
	
	public Order updateOrderById(Long id, Order order) {
		Order order1 = orderRepo.findById(id).get();
		
		OrderMessage orderMessage = new OrderMessage(order1.getBookId(), order1.getQuantity(), "CANCEL");
		
		producerService.sendOrderMessage(orderMessage);
		
		order1.setQuantity(order.getQuantity());
		
		orderMessage.setBookId(order1.getBookId());
		orderMessage.setQuantity(order1.getQuantity());
		orderMessage.setAction("CREATE");
		
		BookDTO bookDTO = feignService.getBookById(order.getBookId());
		
		order1.setTotalPrice(bookDTO.getPrice()*order.getQuantity());
		
		Order updatedOrder = orderRepo.save(order1);
		
		producerService.sendOrderMessage(orderMessage);
		
		return updatedOrder;
	}
}
