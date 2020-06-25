package com.orders.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.orders.order.exception.OrderNotFoundException;
import com.orders.order.model.OrderItem;
import com.orders.order.model.Orders;
import com.orders.order.model.OrdersDTO;
import com.orders.order.repository.OrderItemsProxy;
import com.orders.order.repository.OrdersRepository;

@RestController
public class OrdersController {
	
	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	private OrderItemsProxy proxy;

	
	@GetMapping(value = "orders/{orderId}")
	public OrdersDTO getItems(@PathVariable String orderId) {
		
		OrdersDTO orders = new OrdersDTO();
		Orders order = orderRepo.findById(Long.valueOf(orderId));
		
		if(order == null) {
			throw new OrderNotFoundException("Order ID : " + orderId);
		}
		
		//Fetch orderItems
		List<OrderItem> orderItems = proxy.getItems(orderId);
		
		//setting to DTO
		orders.setOrderid(Long.valueOf(orderId));
		orders.setCustomerName(order.getCustomerName());
		orders.setOrderDate(order.getOrderDate());
		orders.setShippingAddress(order.getShippingAddress());
		orders.setOrderItems(orderItems);
		
		return orders;
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Void> createItem(@Valid @RequestBody OrdersDTO ordersDTO) {
		
		Orders orders = new Orders();
		orders.setCustomerName(ordersDTO.getCustomerName());
		orders.setOrderDate(ordersDTO.getOrderDate());
		orders.setShippingAddress(ordersDTO.getShippingAddress());
		
		long orderId = orderRepo.createOrder(orders);
		
		for(OrderItem orderItem: ordersDTO.getOrderItems()) {
			orderItem.setOrderId(orderId);
		}
		
		//Create orderItems
		proxy.createItem(ordersDTO.getOrderItems());
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/*
	 * @PutMapping(value = "orders") public ResponseEntity<Orders>
	 * updateItem(@RequestBody Orders item) { return null; }
	 * 
	 * @DeleteMapping(value = "orders/{orderId}") public ResponseEntity<Void>
	 * deleteItem(@PathVariable String orderId) { return null; }
	 */
}
