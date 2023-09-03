package com.inventory.demo.dao.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.demo.dao.entity.Inventory;
import com.inventory.demo.dao.service.InventoryDaoService;
import com.inventory.demo.dao.validator.InventoryOnlineValidation;
import com.inventory.demo.mgmt.exception.ValidationException;
import com.inventory.demo.model.InventoryDto;

@Service("inventoryOnlineValidation")
public class InventoryOnlineValidationImpl implements InventoryOnlineValidation {
	
	@Autowired
	private InventoryDaoService inventoryDaoService;

	@Override
	public void add(InventoryDto inventoryDto) {
		
		Inventory inventory = null;
		if(inventoryDto.getId() != null) {
			inventory = inventoryDaoService.get(inventoryDto.getId());
			if(inventory != null) {
				throw new ValidationException(201l, "Inventory Entity is already present");
			}
		}
		inventory = inventoryDaoService.getbyProductId(inventoryDto.getProductId());
		if(inventory != null) {
			throw new ValidationException(20l, "Inventory is already present for Product Id");
		}
	
	}

	@Override
	public void get(String inventoryId) {
		Inventory inventory = inventoryDaoService.get(inventoryId);
		if(inventory == null) {
			throw new ValidationException(202l, "Inventory does not exists");
		}
	}

	@Override
	public void getByproductId(String productId) {
		Inventory inventory = inventoryDaoService.getbyProductId(productId);
		if(inventory == null) {
			throw new ValidationException(202l, "Inventory does not exists");
		}

	}

	@Override
	public void update(String inventoryId, String productId) {
		Inventory inventory = inventoryDaoService.get(inventoryId);
		if(inventory == null) {
			throw new ValidationException(202l, "Inventory does not exists");
		}
		if(!inventory.getProductId().equals(Long.parseLong(productId))) {
			throw new ValidationException(203l, "Inventory id and Product id is not matching");
		}
	}

	@Override
	public void updateByProductId(String productId) {

		Inventory inventory = inventoryDaoService.getbyProductId(productId);
		if(inventory == null) {
			throw new ValidationException(202l, "Inventory does not exists");
		}
		
	}

}
