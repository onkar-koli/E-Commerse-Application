package com.inventory.demo.dao.service;

import com.inventory.demo.dao.entity.Inventory;

public interface InventoryDaoService {
	
	Inventory add(Inventory inventory);
	
	Inventory get(String inventoryId);
	
	Inventory getbyProductId(String productId);
	
	Inventory updateStock(String id, Inventory inventory);

	Inventory updateStock(Inventory inventory);

}
