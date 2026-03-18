package com.example.order_service.controller;

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

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		return service.saveOrder(order);
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return service.getOrderById(id);
	}
	
	@GetMapping
	public List<Order> getAllOrder(){
		return service.getAllOrder();
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable Long id) {
		service.deleteOrderById(id);
	}
	
	@PutMapping("/{id}")
	public Order updateOrderbyId(@PathVariable Long id, @RequestBody Order order) {
		return service.updateOrderById(id, order);
	}
}
