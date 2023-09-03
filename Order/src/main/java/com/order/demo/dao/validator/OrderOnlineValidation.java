package com.order.demo.dao.validator;

import com.order.demo.mgmt.exception.ValidationException;
import com.order.demo.model.OrderDto;

public interface OrderOnlineValidation {

	void newOrder(OrderDto orderDto) throws ValidationException, Exception;

	void getOrder(String orderId) throws ValidationException;

	void cancelOrder(String orderId) throws ValidationException;

}
