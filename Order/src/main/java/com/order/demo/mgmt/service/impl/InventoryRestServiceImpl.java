package com.order.demo.mgmt.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.demo.mgmt.service.InventoryRestService;
import com.order.demo.model.EcomResponce;
import com.order.demo.model.InventoryDto;

@Service("inventoryRestService")
public class InventoryRestServiceImpl implements InventoryRestService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<EcomResponce> getByProductId(String productId) throws Exception {
		URI inventoryuri = new URI("http://inventory/inventory/getbyproductid?productId="+productId);
		return (ResponseEntity<EcomResponce>)restTemplate.getForEntity(inventoryuri, EcomResponce.class);
	}

	@Override
	public ResponseEntity<EcomResponce> updateByProductId(InventoryDto inventoryDto) throws Exception {
		URI inventoryuri = new URI("http://inventory/inventory/updatebyproductid");
		return (ResponseEntity<EcomResponce>)restTemplate.postForEntity(inventoryuri, inventoryDto, EcomResponce.class);
	}

}