package com.order.demo.mgmt.util;

import com.order.demo.dao.entity.Order;
import com.order.demo.model.OrderDto;

public class OrderUtil {
	
	public static Order getEntity(OrderDto orderDto) {
		Order order = new Order();
		if(orderDto.getId() != null && !orderDto.getId().isEmpty()) {
			order.setId(Long.parseLong(orderDto.getId()));
		}
		order.setProductId(Long.parseLong(orderDto.getProductId()));
		order.setProductQuantity(Integer.parseInt(orderDto.getProductQuantity()));
		return order;
	}
	
	public static OrderDto getModel(Order order) {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId().toString());
		orderDto.setProductId(order.getProductId().toString());
		orderDto.setProductQuantity(order.getProductQuantity().toString());
		return orderDto;
	}

}
