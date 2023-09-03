package com.product.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.demo.dao.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String productName);

}
