package com.product.demo.mgmt.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.demo.mgmt.service.InventoryRestService;
import com.product.demo.model.EcomResponce;
import com.product.demo.model.InventoryDto;

@Service("inventoryRestService")
public class InventoryRestServiceImpl implements InventoryRestService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<EcomResponce> add(InventoryDto inventoryDto) throws Exception {
		URI inventoryuri = new URI("http://inventory/inventory/add");
		return (ResponseEntity<EcomResponce>)restTemplate.postForEntity(inventoryuri, inventoryDto, EcomResponce.class);
	}

}