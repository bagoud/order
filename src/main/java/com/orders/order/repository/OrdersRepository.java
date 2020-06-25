package com.orders.order.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orders.order.model.Orders;

@Repository
@Transactional
public class OrdersRepository {
	
	@Autowired
	EntityManager em;
	
	public long createOrder(Orders orders) {
		em.persist(orders);
		return orders.getOrderid();
	}

	public Orders findById(long orderId) {
		return em.find(Orders.class, orderId);
	}
	
}

