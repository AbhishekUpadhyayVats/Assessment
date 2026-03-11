package com.lpu;

import jakarta.persistence.*;

@Entity
public class Products {

	@Id
	private int Product_ID;
	
	private String Product_name;
	
	@ManyToOne
	private Categories categories;

	public int getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	
}
