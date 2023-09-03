package com.order.demo.dao.service;

import com.order.demo.dao.entity.Order;

public interface OrderDaoService {
	
	public Order newOrder(Order order);
	
	public Order getOrder(String orderId);
	
	public Order cancelOrder(String orderId);

}
