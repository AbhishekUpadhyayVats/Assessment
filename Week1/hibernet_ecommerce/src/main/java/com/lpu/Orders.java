package com.lpu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Orders {

	@Id
	private int Orders_Id;
	
	private String Date;
	
	@ManyToOne
	private Delivery delivery;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToMany
	private List<Products> product;

	public int getOrders_Id() {
		return Orders_Id;
	}

	public void setOrders_Id(int orders_Id) {
		Orders_Id = orders_Id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}
}
