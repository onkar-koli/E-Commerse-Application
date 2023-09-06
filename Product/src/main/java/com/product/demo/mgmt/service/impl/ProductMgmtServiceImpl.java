package com.product.demo.mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.demo.dao.entity.Product;
import com.product.demo.dao.service.ProductDaoService;
import com.product.demo.mgmt.exception.ValidationException;
import com.product.demo.mgmt.service.EcomResponceService;
import com.product.demo.mgmt.service.InventoryFeignClient;
import com.product.demo.mgmt.service.ProductMgmtService;
import com.product.demo.mgmt.util.ProductUtil;
import com.product.demo.mgmt.validator.ProductValidator;
import com.product.demo.model.InventoryDto;
import com.product.demo.model.ProductDto;

@Service("productMgmtService")
public class ProductMgmtServiceImpl implements ProductMgmtService {

	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private ProductDaoService productDaoService;;
	
	@Autowired
	private EcomResponceService ecomResponceService;

	@Autowired
	private InventoryFeignClient inventoryFeignClient;
	
	@Override
	public ResponseEntity<?> add(ProductDto productDto) {

		ResponseEntity<?> res = null;
		try {
			productValidator.add(productDto);
			Product product = ProductUtil.getEntity(productDto);
			product = productDaoService.add(product);
			inventoryFeignClient.addInventory(getInventoryDto(product));
			res = ecomResponceService.getSuccesResponce(ProductUtil.getModel(product));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;

	}

	private InventoryDto getInventoryDto(Product product) {
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setProductId(product.getId().toString());
		inventoryDto.setInventoryStock("0");
		return inventoryDto;
	}

	@Override
	public ResponseEntity<?> getbyId(String productId) {

		ResponseEntity<?> res = null;
		try {
			productValidator.getbyId(productId);
			res = ecomResponceService.getSuccesResponce(productDaoService.getbyId(productId));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;

	}

	@Override
	public ResponseEntity<?> delete(String productId) {

		ResponseEntity<?> res = null;
		try {
			productValidator.delete(productId);
			productDaoService.delete(productId);
			res = ecomResponceService.getSuccesResponce(productId);
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;

	}

	@Override
	public ResponseEntity<?> get() {
		
		ResponseEntity<?> res = null;
		try {
			res = ecomResponceService.getSuccesResponce(productDaoService.get());
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
	
	}

}
