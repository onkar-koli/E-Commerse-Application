package com.product.demo.mgmt.validator.offlinevalidation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.mgmt.validator.offlinevalidation.OfflineValidator;
import com.product.demo.mgmt.validator.offlinevalidation.ProductOfflineValidation;
import com.product.demo.model.ProductDto;

@Service("productOfflineValidation")
public class ProductOfflineValidationImpl implements ProductOfflineValidation {
	
	@Autowired
	private OfflineValidator offlineValidator;

	@Override
	public void add(ProductDto productDto) {
		offlineValidator.checkName(productDto.getProductName());
		offlineValidator.checkDescription(productDto.getDescription());
		offlineValidator.checkPrice(productDto.getPrice());
	}

	@Override
	public void get(String productId) {
		offlineValidator.checkId(productId);
	}

	@Override
	public void delete(String productId) {
		offlineValidator.checkId(productId);
	}

}
