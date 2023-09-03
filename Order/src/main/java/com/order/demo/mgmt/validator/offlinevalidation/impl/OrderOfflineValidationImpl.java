package com.order.demo.mgmt.validator.offlinevalidation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.mgmt.validator.offlinevalidation.OfflineValidator;
import com.order.demo.mgmt.validator.offlinevalidation.OrderOfflineValidation;
import com.order.demo.model.OrderDto;

@Service("orderOfflineValidation")
public class OrderOfflineValidationImpl implements OrderOfflineValidation {
	
	@Autowired
	private OfflineValidator offlineValidator;

	@Override
	public void newOrder(OrderDto orderDto) {

		offlineValidator.checkProductId(orderDto.getProductId());
		offlineValidator.checkProductQuantity(orderDto.getProductQuantity());
		
	}

	@Override
	public void getOrder(String orderId) {

		offlineValidator.checkId(orderId);
		
	}

	@Override
	public void cancelOrder(String orderId) {
		
		offlineValidator.checkId(orderId);
		
	}

}