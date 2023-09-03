package com.product.demo.dao.valadator;

import com.product.demo.model.ProductDto;

public interface ProductOnlineValidation {
	
	public void add(ProductDto productDto);
	
	public void get(String productId);
	
	public void delete(String productId);

}
