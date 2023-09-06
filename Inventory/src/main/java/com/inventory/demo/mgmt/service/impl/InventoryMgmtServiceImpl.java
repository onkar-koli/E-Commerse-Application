package com.inventory.demo.mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.demo.dao.entity.Inventory;
import com.inventory.demo.dao.service.InventoryDaoService;
import com.inventory.demo.mgmt.exception.ValidationException;
import com.inventory.demo.mgmt.service.EcomResponceService;
import com.inventory.demo.mgmt.service.InventoryMgmtService;
import com.inventory.demo.mgmt.util.InventoryUtil;
import com.inventory.demo.mgmt.validator.InventoryValidator;
import com.inventory.demo.model.InventoryDto;

@Service("inventoryMgmtService")
public class InventoryMgmtServiceImpl implements InventoryMgmtService {

	@Autowired
	private InventoryDaoService inventoryDaoService;

	@Autowired
	private InventoryValidator inventoryValidator;

	@Autowired
	private EcomResponceService ecomResponceService;

	@Override
	public ResponseEntity<?> add(InventoryDto inventoryDto) {

		ResponseEntity<?> res = null;
		try {
			inventoryValidator.add(inventoryDto);
			Inventory inventory = InventoryUtil.getEntity(inventoryDto);
			res = ecomResponceService.getSuccesResponce(inventoryDaoService.add(inventory));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;

	}

	@Override
	public ResponseEntity<?> get(String inventoryId) {

		ResponseEntity<?> res = null;
		try {
			inventoryValidator.get(inventoryId);
			res = ecomResponceService.getSuccesResponce(inventoryDaoService.get(inventoryId));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
	}

	@Override
	public ResponseEntity<?> getByProductId(String productId) {

		ResponseEntity<?> res = null;
		try {
			inventoryValidator.getByproductId(productId);
			Inventory inventory = inventoryDaoService.getbyProductId(productId);
			res = ecomResponceService.getSuccesResponce(InventoryUtil.getModel(inventory));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
	}

	@Override
	public ResponseEntity<?> update(String id, InventoryDto inventoryDto) {

		ResponseEntity<?> res = null;
		try {
			inventoryValidator.updateById(id, inventoryDto);
			Inventory inventory = InventoryUtil.getEntity(inventoryDto);
			res = ecomResponceService.getSuccesResponce(inventoryDaoService.updateStock(id, inventory));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;
	}

	@Override
	public ResponseEntity<?> updateSaleInventory(InventoryDto inventoryDto) {

		ResponseEntity<?> res = null;
		try {
			inventoryValidator.updateSaleInventory(inventoryDto);
			Inventory newI = InventoryUtil.getEntity(inventoryDto);
			res = ecomResponceService.getSuccesResponce(inventoryDaoService.updateSaleInventory(newI));
		} catch (ValidationException e) {
			res = ecomResponceService.getUncheckedExceptionResponce(e);
		} catch (Exception e) {
			res = ecomResponceService.getCheckedExceptionResponce(e);
		}
		return res;

	}

}
