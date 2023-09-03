package com.order.demo.mgmt.validator;

import com.order.demo.model.OrderDto;

public interface OrderValidator {
	
	void newOrder(OrderDto orderDto) throws Exception;
	
	void getOrder(String orderId) throws Exception;
	
	void cancelOrder(String orderId) throws Exception;

}
