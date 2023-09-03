package com.inventory.demo.mgmt.validator.inventoryofflinevalidation;

import com.inventory.demo.model.InventoryDto;

public interface InventoryOfflineValidation {

	void add(InventoryDto inventoryDto);

	void get(String inventoryId);

	void getByproductId(String productId);

	void updateById(String id, InventoryDto inventoryDto);

	void updateByProductId(InventoryDto inventoryDto);

}
