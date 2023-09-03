package com.product.demo.mgmt.validator;

import com.product.demo.model.ProductDto;

public interface ProductValidator {
	
	public void add(ProductDto productDto);
	
	public void getbyId(String productId);
	
	public void delete( String productId);

}
