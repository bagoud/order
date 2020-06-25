package com.orders.order.model;

public class OrderItem {

	private long orderId;
	private long productcode;
	private String productname;
	private String quantity;
	
	
	public OrderItem() {
	  
	}
	
	public OrderItem(long productcode, String productName, String quantity) {
		this.productcode = productcode;
		this.productname = productName;
		this.quantity = quantity;
	}
	
	
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public void setProductCode(long productcode) {
		this.productcode = productcode;
	}

	public long getProductCode() {
		return productcode;
	}
	
	public String getProductName() {
		return productname;
	}
	public void setProductName(String productName) {
		this.productname = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Order Item - " + this.productcode + ", " + this.productname + ", " + this.quantity;
	}
}
