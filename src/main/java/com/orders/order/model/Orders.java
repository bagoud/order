package com.orders.order.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders
 {
	@Id
	private long orderid;
	private String customername;
	private Date orderdate;
	private String shippingaddress;
	/*private List<OrderItem> orderItems;
	private Double total;*/
	
	
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public String getCustomerName() {
		return customername;
	}
	public void setCustomerName(String customerName) {
		this.customername = customerName;
	}
	public Date getOrderDate() {
		return orderdate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderdate = orderDate;
	}
	public String getShippingAddress() {
		return shippingaddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingaddress = shippingAddress;
	}
	/*public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}*/
	
	public String toString() {
		return "Order Item - ";
	}
}