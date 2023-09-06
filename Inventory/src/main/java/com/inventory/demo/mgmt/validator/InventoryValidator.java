package com.inventory.demo.mgmt.validator;

import com.inventory.demo.model.InventoryDto;

public interface InventoryValidator {
	
	void add(InventoryDto inventoryDto);
	
	void get(String inventoryId);
	
	void getByproductId(String productId);
	
	void updateById(String id, InventoryDto inventoryDto);

	void updateSaleInventory(InventoryDto inventoryDto);

}
