package com.inventory.demo.mgmt.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.demo.dao.validator.InventoryOnlineValidation;
import com.inventory.demo.mgmt.exception.ValidationException;
import com.inventory.demo.mgmt.validator.InventoryValidator;
import com.inventory.demo.mgmt.validator.inventoryofflinevalidation.InventoryOfflineValidation;
import com.inventory.demo.model.InventoryDto;

@Service("inventoryValidator")
public class InventoryValidatorImpl implements InventoryValidator {
	
	@Autowired
	private InventoryOfflineValidation inventoryOfflineValidation;

	@Autowired
	private InventoryOnlineValidation inventoryOnlineValidation;

	@Override
	public void add(InventoryDto inventoryDto) {

		inventoryOfflineValidation.add(inventoryDto);
		inventoryOnlineValidation.add(inventoryDto);
		
	}

	@Override
	public void get(String inventoryId) {

		inventoryOfflineValidation.get(inventoryId);
		inventoryOnlineValidation.get(inventoryId);
		
	}

	@Override
	public void getByproductId(String productId) {

		inventoryOfflineValidation.getByproductId(productId);
		inventoryOnlineValidation.getByproductId(productId);
		
	}

	@Override
	public void updateById(String id, InventoryDto inventoryDto) {
		if(inventoryDto.getId() != null && !id.equalsIgnoreCase(inventoryDto.getId())) {
			throw new ValidationException(103l, "Inventory Id is not matching with model");
		}
		inventoryOfflineValidation.updateById(id, inventoryDto);
		inventoryOnlineValidation.update(id, inventoryDto.getProductId());
	}

	@Override
	public void updateSaleInventory(InventoryDto inventoryDto) {
		inventoryOfflineValidation.updateSaleInventory(inventoryDto);
		inventoryOnlineValidation.updateSaleInventory(inventoryDto.getProductId());
	}
	
}
