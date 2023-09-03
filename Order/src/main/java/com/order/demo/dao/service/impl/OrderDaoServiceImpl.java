package com.order.demo.dao.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.dao.entity.Order;
import com.order.demo.dao.repository.OrderRepository;
import com.order.demo.dao.service.OrderDaoService;

@Service("orderDaoService")
public class OrderDaoServiceImpl implements OrderDaoService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order newOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrder(String orderId) {
		Optional<Order> optional = orderRepository.findById(Long.parseLong(orderId));
		if(optional.isEmpty())
			return null;
		return optional.get();
	}

	@Override
	public Order cancelOrder(String orderId) {
		orderRepository.deleteById(Long.parseLong(orderId));
		return null;
	}

}
