package com.lpu;

import jakarta.persistence.*;

@Entity
public class Categories {

	@Id
	private int Category_ID;
	
	private String Category_name;
	
	private String Category_type;

	public int getCategory_ID() {
		return Category_ID;
	}

	public void setCategory_ID(int category_ID) {
		Category_ID = category_ID;
	}

	public String getCategory_name() {
		return Category_name;
	}

	public void setCategory_name(String category_name) {
		Category_name = category_name;
	}

	public String getCategory_type() {
		return Category_type;
	}

	public void setCategory_type(String category_type) {
		Category_type = category_type;
	}	
}
