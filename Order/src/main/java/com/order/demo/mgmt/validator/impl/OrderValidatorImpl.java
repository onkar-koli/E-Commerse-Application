package com.order.demo.mgmt.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.dao.validator.OrderOnlineValidation;
import com.order.demo.mgmt.exception.ValidationException;
import com.order.demo.mgmt.validator.OrderValidator;
import com.order.demo.mgmt.validator.offlinevalidation.OrderOfflineValidation;
import com.order.demo.model.OrderDto;

@Service("orderValidator")
public class OrderValidatorImpl implements OrderValidator{
	
	@Autowired
	private OrderOfflineValidation orderOfflineValidation;
	
	@Autowired
	private OrderOnlineValidation orderOnlineValidation;

	@Override
	public void newOrder(OrderDto orderDto) throws ValidationException, Exception{

		orderOfflineValidation.newOrder(orderDto);
		orderOnlineValidation.newOrder(orderDto);
		
	}

	@Override
	public void getOrder(String orderId) throws Exception {

		orderOfflineValidation.getOrder(orderId);
		orderOnlineValidation.getOrder(orderId);
		
	}

	@Override
	public void cancelOrder(String orderId) throws Exception {

		orderOfflineValidation.cancelOrder(orderId);
		orderOnlineValidation.cancelOrder(orderId);
		
	}

}
