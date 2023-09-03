package com.order.demo.mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.order.demo.dao.entity.Order;
import com.order.demo.dao.service.OrderDaoService;
import com.order.demo.mgmt.exception.ValidationException;
import com.order.demo.mgmt.service.EcomResponceService;
import com.order.demo.mgmt.service.InventoryRestService;
import com.order.demo.mgmt.service.OrderMgmtService;
import com.order.demo.mgmt.util.OrderUtil;
import com.order.demo.mgmt.validator.OrderValidator;
import com.order.demo.model.InventoryDto;
import com.order.demo.model.OrderDto;

@Service("orderMgmtService")
public class OrderMgmtServiceImpl implements OrderMgmtService {
	
	@Autowired
	private OrderValidator orderValidator;
	
	@Autowired
	private OrderDaoService orderDaoService;
	
	@Autowired
	private EcomResponceService ecomResponceService;
	
	@Autowired
	private InventoryRestService inventoryRestService;

	@Override
	public ResponseEntity<?> newOrder(OrderDto orderDto) {

		ResponseEntity<?> res = null;
		try {
			orderValidator.newOrder(orderDto);
			Order newOrder = orderDaoService.newOrder(OrderUtil.getEntity(orderDto));
			InventoryDto inventoryDto = getInventoryModel(orderDto);
			inventoryRestService.updateByProductId(inventoryDto);
			res = ecomResponceService.getSuccesResponce(OrderUtil.getModel(newOrder));
		} catch (ValidationException e) {
			res =ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
		
	}

	@Override
	public ResponseEntity<?> getOrder(String orderId) {
		
		ResponseEntity<?> res = null;
		try {
			orderValidator.getOrder(orderId);
			res = ecomResponceService.getSuccesResponce(orderDaoService.getOrder(orderId));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
		
	}

	@Override
	public ResponseEntity<?> cancelOrder(String orderId) {

		ResponseEntity<?> res = null;
		try {
			orderValidator.cancelOrder(orderId);
			res = ecomResponceService.getSuccesResponce(orderDaoService.cancelOrder(orderId));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
		
	}
	
	private InventoryDto getInventoryModel(OrderDto orderDto) {
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setProductId(orderDto.getProductId());
		inventoryDto.setInventoryStock(orderDto.getProductQuantity());
		return inventoryDto;
	}

}
