package com.inventory.demo.mgmt.validator.inventoryofflinevalidation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.demo.mgmt.validator.inventoryofflinevalidation.InventoryOfflineValidation;
import com.inventory.demo.mgmt.validator.inventoryofflinevalidation.OfflineValidator;
import com.inventory.demo.model.InventoryDto;

@Service("inventoryOfflineValidation")
public class InventoryOfflineValidationImpl implements InventoryOfflineValidation {
	
	@Autowired
	private OfflineValidator offlineValidator;

	@Override
	public void add(InventoryDto inventoryDto) {
		offlineValidator.checkProductId(inventoryDto.getProductId());
		offlineValidator.checkInventoryStock(inventoryDto.getInventoryStock());
	}

	@Override
	public void get(String inventoryId) {
		offlineValidator.checkId(inventoryId);
	}

	@Override
	public void getByproductId(String productId) {
		offlineValidator.checkProductId(productId);
	}

	@Override
	public void updateByProductId(InventoryDto inventoryDto) {
		offlineValidator.checkProductId(inventoryDto.getProductId());
		offlineValidator.checkInventoryStock(inventoryDto.getInventoryStock());
	}

	@Override
	public void updateById(String id, InventoryDto inventoryDto) {
		offlineValidator.checkId(id);
		offlineValidator.checkProductId(inventoryDto.getProductId());
		offlineValidator.checkInventoryStock(inventoryDto.getInventoryStock());
	}

}
