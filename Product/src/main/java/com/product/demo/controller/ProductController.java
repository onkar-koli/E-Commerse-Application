package com.product.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.mgmt.service.ProductMgmtService;
import com.product.demo.model.ProductDto;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductMgmtService productMgmtService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ProductDto productDto){
		return productMgmtService.add(productDto);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getbyId(@RequestParam("productId") String productId){
		return productMgmtService.getbyId(productId);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(){
		return productMgmtService.get();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("productId") String productId){
		return productMgmtService.delete(productId);
	}

}
