package com.inventory.demo.dao.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.demo.dao.entity.Inventory;
import com.inventory.demo.dao.repository.InventoryRepository;
import com.inventory.demo.dao.service.InventoryDaoService;

@Service("inventoryDaoService")
public class InventoryDaoServiceImpl implements InventoryDaoService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public Inventory add(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory get(String inventoryId) {
		Optional<Inventory> optional = inventoryRepository.findById(Long.parseLong(inventoryId));
		if(optional.isEmpty()) {
			return null;
		} 
		return optional.get();
	}

	@Override
	public Inventory getbyProductId(String productId) {
		return inventoryRepository.findByProductId(Long.parseLong(productId));
	}

	@Override
	public Inventory updateStock(String id, Inventory inventory) {
		Inventory old = getbyProductId(inventory.getProductId().toString());
		inventoryRepository.delete(old);
		inventory.setAvailableStock(inventory.getAvailableStock()+old.getAvailableStock());
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory updateStock(Inventory inventory) {
		Inventory old = getbyProductId(inventory.getProductId().toString());
		inventoryRepository.delete(old);
		old.setAvailableStock(old.getAvailableStock()-inventory.getAvailableStock());
		return inventoryRepository.save(old);
	}
	
	

}