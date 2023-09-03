package com.inventory.demo.mgmt.util;

import com.inventory.demo.dao.entity.Inventory;
import com.inventory.demo.model.InventoryDto;

public class InventoryUtil {
	
	public static Inventory getEntity(InventoryDto inventoryDto) {
		Inventory inventory = new Inventory();
		if(inventoryDto.getId() != null) {
			inventory.setId(Long.parseLong(inventoryDto.getId()));
		}
		inventory.setProductId(Long.parseLong(inventoryDto.getProductId()));
		inventory.setAvailableStock(Integer.parseInt(inventoryDto.getInventoryStock()));
		return inventory;
	}
	
	public static InventoryDto getModel(Inventory inventory) {
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setId(inventory.getId().toString());
		inventoryDto.setProductId(inventory.getProductId().toString());
		inventoryDto.setInventoryStock(inventory.getAvailableStock().toString());
		return inventoryDto;
	}

}
