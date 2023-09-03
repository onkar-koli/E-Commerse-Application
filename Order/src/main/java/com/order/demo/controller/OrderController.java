package com.order.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.mgmt.service.OrderMgmtService;
import com.order.demo.model.OrderDto;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderMgmtService orderMgmtService;
	
	@PostMapping("/neworder")
	public ResponseEntity<?> newOrder(@RequestBody OrderDto orderDto){
		return orderMgmtService.newOrder(orderDto);
	}
	
	@GetMapping(value = "/getorder")
	public ResponseEntity<?> getOrder(@RequestParam("orderId") String orderId){
		return orderMgmtService.getOrder(orderId);
	}
	
	@DeleteMapping(value = "/cancelorder")
	public ResponseEntity<?> cancelOrder(@RequestParam("orderId") String orderId){
		return orderMgmtService.cancelOrder(orderId);
	}

}
