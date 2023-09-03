package com.inventory.demo.mgmt.validator.inventoryofflinevalidation.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.inventory.demo.mgmt.exception.ValidationException;
import com.inventory.demo.mgmt.regularexpression.RegularExpression;
import com.inventory.demo.mgmt.validator.inventoryofflinevalidation.OfflineValidator;

@Service("offlineValidator")
public class OfflineValidatorImpl implements OfflineValidator {

	@Override
	public void checkProductId(String productId) {
		
		if (productId == null || productId.isEmpty()) {
			throw new ValidationException(101l, "Product Id cannot be null");
		}
		if (!Pattern.matches(RegularExpression.number, productId)) {
			throw new ValidationException(102l, "Product Id is invalid");
		}
		
	}

	@Override
	public void checkInventoryStock(String productQuantity) {
		
		if (productQuantity == null || productQuantity.isEmpty()) {
			throw new ValidationException(101l, "Product Quantity cannot be null");
		}
		if (!Pattern.matches(RegularExpression.number, productQuantity)) {
			throw new ValidationException(102l, "Product Quantity is invalid");
		}
		
	}

	@Override
	public void checkId(String id) {
		
		if (id == null || id.isEmpty()) {
			throw new ValidationException(101l, "Inventory Id cannot be null");
		}
		if (!Pattern.matches(RegularExpression.number, id)) {
			throw new ValidationException(102l, "Inventory Id is invalid");
		}

	}

}
