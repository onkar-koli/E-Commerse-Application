package com.product.demo.dao.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.entity.Product;
import com.product.demo.dao.service.ProductDaoService;
import com.product.demo.dao.valadator.ProductOnlineValidation;
import com.product.demo.mgmt.exception.ValidationException;
import com.product.demo.model.ProductDto;

@Service("productOnlineValidation")
public class ProductOnlineValidationImpl implements ProductOnlineValidation {
	
	@Autowired
	private ProductDaoService productDaoService;

	@Override
	public void add(ProductDto productDto) {
		Product product = productDaoService.getbyName(productDto.getProductName());
		if(product != null) {
			throw new ValidationException(201l, "Product Name is already exists");
		}
	}

	@Override
	public void get(String productId) {
		Product product = productDaoService.getbyId(productId);
		if(product == null) {
			throw new ValidationException(202l, "Product id does not exists");
		}
	}

	@Override
	public void delete(String productId) {
		
		Product product = productDaoService.getbyId(productId);
		if(product == null) {
			throw new ValidationException(202l, "Product id does not exists");
		}

	}

}
