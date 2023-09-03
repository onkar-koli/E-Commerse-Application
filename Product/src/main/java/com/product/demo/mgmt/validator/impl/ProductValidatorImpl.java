package com.product.demo.mgmt.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.valadator.ProductOnlineValidation;
import com.product.demo.mgmt.validator.ProductValidator;
import com.product.demo.mgmt.validator.offlinevalidation.ProductOfflineValidation;
import com.product.demo.model.ProductDto;

@Service("productValidator")
public class ProductValidatorImpl implements ProductValidator{
	
	@Autowired
	private ProductOfflineValidation productOfflineValidation;
	
	@Autowired
	private ProductOnlineValidation productOnlineValidation;

	@Override
	public void add(ProductDto productDto) {

		productOfflineValidation.add(productDto);
		productOnlineValidation.add(productDto);
		
	}

	@Override
	public void getbyId(String productId) {

		productOfflineValidation.get(productId);
		productOnlineValidation.get(productId);
		
	}

	@Override
	public void delete(String productId) {

		productOfflineValidation.delete(productId);
		productOnlineValidation.delete(productId);
		
	}	

}