package com.order.demo.mgmt.validator.offlinevalidation;

import com.order.demo.mgmt.exception.ValidationException;
import com.order.demo.model.OrderDto;

public interface OrderOfflineValidation {

	void newOrder(OrderDto orderDto) throws ValidationException;

	void getOrder(String orderId) throws ValidationException;

	void cancelOrder(String orderId) throws ValidationException;

}
