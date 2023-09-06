package com.inventory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.mgmt.service.InventoryMgmtService;
import com.inventory.demo.model.InventoryDto;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryMgmtService inventoryMgmtService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody InventoryDto inventoryDto){
		return inventoryMgmtService.add(inventoryDto);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(@RequestParam("inventoryId") String inventoryId){
		return inventoryMgmtService.get(inventoryId);
	}
	
	@GetMapping("/getbyproductid")
	public ResponseEntity<?> getByProductId(@RequestParam("productId") String productId){
		return inventoryMgmtService.getByProductId(productId);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody InventoryDto inventoryDto){
		return inventoryMgmtService.update(id, inventoryDto);
	}
	
	@PostMapping("/updatesaleinventory")
	public ResponseEntity<?> updateSaleInventory(@RequestBody InventoryDto inventoryDto){
		return inventoryMgmtService.updateSaleInventory(inventoryDto);
	}
 
}
