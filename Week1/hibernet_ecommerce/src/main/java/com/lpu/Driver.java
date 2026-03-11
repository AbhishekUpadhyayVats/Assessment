package com.lpu;
import java.util.Arrays;

import jakarta.persistence.*;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Delivery delivery = new Delivery();
		delivery.setDelivery_ID(1000);
		delivery.setStatus("Pending");
		delivery.setType("Online");
		
		Customer customer = new Customer();
		customer.setCustomer_ID(100);
		customer.setAddress("Bihar");
		customer.setEmail("xyz@gmail.com");
		customer.setName("Abhishek");
		
		Categories categories = new Categories();
		categories.setCategory_ID(10);
		categories.setCategory_name("Electronics");
		categories.setCategory_type("Market Order");
		
		Products product1 = new Products();
		product1.setProduct_name("Iphone");
		product1.setProduct_ID(500);
		product1.setCategories(categories);
		
		Products product2 = new Products();
		product2.setProduct_ID(510);
		product2.setProduct_name("HP");
		product2.setCategories(categories);
		
		Orders orders = new Orders();
		orders.setOrders_Id(101);
		orders.setCustomer(customer);
		orders.setDate("12-09-2024");
		orders.setProduct(Arrays.asList(product1,product2));
		orders.setDelivery(delivery);
		

		tx.begin();
		em.persist(orders);
		em.persist(product1);
		em.persist(product2);
		em.persist(delivery);
		em.persist(categories);
		em.persist(customer);
		tx.commit();
	}
}
