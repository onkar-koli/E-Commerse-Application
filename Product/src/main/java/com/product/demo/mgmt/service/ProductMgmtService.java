package com.product.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.product.demo.model.ProductDto;

public interface ProductMgmtService {

	ResponseEntity<?> add(ProductDto productDto);

	ResponseEntity<?> getbyId(String productId);
	
	ResponseEntity<?> get();

	ResponseEntity<?> delete(String productId);

}
