package com.inventory.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.inventory.demo.model.InventoryDto;

public interface InventoryMgmtService {
	
	ResponseEntity<?> add(InventoryDto inventoryDto);
	
	ResponseEntity<?> get(String inventoryId);
	
	ResponseEntity<?> getByProductId(String productId);
	
	ResponseEntity<?> update(String id, InventoryDto inventoryDto);

	ResponseEntity<?> updateSaleInventory(InventoryDto inventoryDto);

}
