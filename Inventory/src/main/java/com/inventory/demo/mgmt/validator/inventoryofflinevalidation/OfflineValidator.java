package com.inventory.demo.mgmt.validator.inventoryofflinevalidation;

public interface OfflineValidator {

	void checkProductId(String productId);

	void checkInventoryStock(String productQuantity);

	void checkId(String id);

}
