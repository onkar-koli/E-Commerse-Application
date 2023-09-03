package com.product.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.product.demo.model.EcomResponce;
import com.product.demo.model.InventoryDto;

public interface InventoryRestService {
	
	ResponseEntity<EcomResponce> add(InventoryDto inventoryDto) throws Exception;

}
