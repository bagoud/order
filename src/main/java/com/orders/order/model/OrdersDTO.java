package com.orders.order.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrdersDTO {
	
	private long orderid;
	@Size(min=4, message="Name should contain atleast 4 characters")
	private String customerName;
	@NotNull(message = "order date cannot be null")
	private Date orderDate;
	private String shippingAddress;
	private List<OrderItem> orderItems;
	
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
