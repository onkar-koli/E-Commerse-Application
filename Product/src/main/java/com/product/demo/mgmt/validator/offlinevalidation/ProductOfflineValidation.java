package com.product.demo.mgmt.validator.offlinevalidation;

import com.product.demo.model.ProductDto;

public interface ProductOfflineValidation {
	
	public void add(ProductDto productDto);
	
	public void get(String productId);
	
	public void delete(String productId);

}
