package com.product.demo.dao.service;

import java.util.List;

import com.product.demo.dao.entity.Product;

public interface ProductDaoService {

	Product add(Product product);

	Product getbyId(String productId);

	void delete(String productId);
	
	List<Product> get();

	Product getbyName(String productName);

}
