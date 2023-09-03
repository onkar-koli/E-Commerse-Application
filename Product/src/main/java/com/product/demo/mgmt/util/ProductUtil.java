package com.product.demo.mgmt.util;

import com.product.demo.dao.entity.Product;
import com.product.demo.model.ProductDto;

public class ProductUtil {
	
	public static Product getEntity(ProductDto productDto) {
		
		Product product = new Product();
		if(productDto.getId() != null)
			product.setId(Long.parseLong(productDto.getId()));
		product.setName(productDto.getProductName());
		product.setDescription(productDto.getDescription());
		product.setPrice(Integer.parseInt(productDto.getPrice()));
		return product;
		
	}
	
	public static ProductDto getModel(Product product) {
		
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId().toString());
		productDto.setProductName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice().toString());
		return productDto;
		
	}

}