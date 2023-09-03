package com.product.demo.dao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.entity.Product;
import com.product.demo.dao.repository.ProductRepository;
import com.product.demo.dao.service.ProductDaoService;

@Service("productDaoService")
public class ProductDaoServiceImpl implements ProductDaoService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product add(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getbyId(String productId) {
		Optional<Product> optional = productRepository.findById(Long.parseLong(productId));
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	@Override
	public void delete(String productId) {
		productRepository.deleteById(Long.parseLong(productId));
	}

	@Override
	public List<Product> get() {
		return productRepository.findAll();
	}

	@Override
	public Product getbyName(String productName) {
		return productRepository.findByName(productName);
	}

}