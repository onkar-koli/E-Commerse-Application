package com.order.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.order.demo.model.EcomResponce;
import com.order.demo.model.InventoryDto;

public interface InventoryRestService {
	
	ResponseEntity<EcomResponce> getByProductId(String productId) throws Exception;

	ResponseEntity<EcomResponce> updateByProductId(InventoryDto inventoryDto) throws Exception;

}
