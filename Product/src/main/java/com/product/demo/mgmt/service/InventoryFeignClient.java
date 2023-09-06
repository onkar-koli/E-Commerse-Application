package com.product.demo.mgmt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.demo.model.EcomResponce;
import com.product.demo.model.InventoryDto;

@FeignClient(value = "inventory")
public interface InventoryFeignClient {
	
	@PostMapping("/inventory/add")
	public ResponseEntity<EcomResponce> addInventory(@RequestBody InventoryDto inventoryDto);

}
