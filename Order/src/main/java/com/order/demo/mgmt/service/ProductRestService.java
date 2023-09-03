package com.order.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.order.demo.model.EcomResponce;

public interface ProductRestService {
	
	ResponseEntity<EcomResponce> getByProductId(String productId) throws Exception;

}
