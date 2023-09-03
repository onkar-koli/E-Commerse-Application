package com.inventory.demo.dao.validator;

import com.inventory.demo.model.InventoryDto;

public interface InventoryOnlineValidation {

	void add(InventoryDto inventoryDto);

	void get(String inventoryId);

	void getByproductId(String productId);

	void update(String inventoryId, String productId);

	void updateByProductId(String productId);

}
