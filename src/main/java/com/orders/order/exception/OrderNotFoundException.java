package com.orders.order.exception;

public class OrderNotFoundException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
