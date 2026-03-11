package com.lpu;

import jakarta.persistence.*;

@Entity
public class Delivery {

	@Id
	private int Delivery_ID;
	
	private String Type;
	
	private String Status;

	public int getDelivery_ID() {
		return Delivery_ID;
	}

	public void setDelivery_ID(int delivery_ID) {
		Delivery_ID = delivery_ID;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
}
