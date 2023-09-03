package com.order.demo.dao.validator.impl;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.order.demo.dao.entity.Order;
import com.order.demo.dao.service.OrderDaoService;
import com.order.demo.dao.validator.OrderOnlineValidation;
import com.order.demo.mgmt.exception.ValidationException;
import com.order.demo.mgmt.service.InventoryRestService;
import com.order.demo.mgmt.service.ProductRestService;
import com.order.demo.model.EcomResponce;
import com.order.demo.model.OrderDto;

@Service("orderOnlineValidation")
public class OrderOnlineValidationImpl implements OrderOnlineValidation {
	
	@Autowired
	private OrderDaoService orderDaoService;
	
	@Autowired
	private InventoryRestService inventoryRestService;
	
	@Autowired
	private ProductRestService productRestService;

	@Override
	public void newOrder(OrderDto orderDto) throws ValidationException, Exception {
		
		ResponseEntity<EcomResponce> res = productRestService.getByProductId(orderDto.getProductId());
		if(res.getBody().getErrorMessage() != null) {
			throw new ValidationException(Long.parseLong(res.getBody().getErrorCode()), 
					res.getBody().getErrorMessage());
		}
		res = inventoryRestService.getByProductId(orderDto.getProductId());
		if(res.getBody().getErrorMessage() != null) {
			throw new ValidationException(Long.parseLong(res.getBody().getErrorCode()),
					res.getBody().getErrorMessage());
		}
		LinkedHashMap<String, String> lhm = (LinkedHashMap<String, String>) res.getBody().getObj();
		if(Long.parseLong(lhm.get("inventoryStock")) < Long.parseLong(orderDto.getProductQuantity())) {
			throw new ValidationException(204l, "Product does not have suffient stock at inventory");
		}
		
	}

	@Override
	public void getOrder(String orderId) {
		Order order = orderDaoService.getOrder(orderId);
		if(order == null) {
			throw new ValidationException(202l, "Order id is does not exists");
		}
	}

	@Override
	public void cancelOrder(String orderId) {
		Order order = orderDaoService.getOrder(orderId);
		if(order == null) {
			throw new ValidationException(202l, "Order id is does not exists");
		}
	}

}
