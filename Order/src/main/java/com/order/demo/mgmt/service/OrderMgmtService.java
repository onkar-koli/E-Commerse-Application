package com.order.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.order.demo.model.OrderDto;

public interface OrderMgmtService {
	
	ResponseEntity<?> newOrder(OrderDto orderDto);
	
	ResponseEntity<?> getOrder(String orderId);
	
	ResponseEntity<?> cancelOrder(String orderId);

}
