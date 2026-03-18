package com.example.book_service.sharedDto;


public class OrderMessage {

	private Long bookId;
	private Integer quantity;
	private String action;
	
	public OrderMessage() {
	}

	public OrderMessage(Long bookId, Integer quantity,String action) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
		this.action = action;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
