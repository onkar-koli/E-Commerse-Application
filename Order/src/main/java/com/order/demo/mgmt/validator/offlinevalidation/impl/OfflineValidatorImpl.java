package com.order.demo.mgmt.validator.offlinevalidation.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.order.demo.mgmt.exception.ValidationException;
import com.order.demo.mgmt.regularexpression.RegularExpression;
import com.order.demo.mgmt.validator.offlinevalidation.OfflineValidator;

@Service("offlineValidator")
public class OfflineValidatorImpl implements OfflineValidator {

	@Override
	public void checkProductId(String productId) {
		if(productId == null || productId.isEmpty()) {
			throw new ValidationException(101l, "Product id cannot be null");
		}
		if(!Pattern.matches(RegularExpression.number, productId)) {
			throw new ValidationException(102l, "Product id is not valid");
		}
	}

	@Override
	public void checkProductQuantity(String productQuantity) {
		if(productQuantity == null || productQuantity.isEmpty()) {
			throw new ValidationException(101l, "Product Quantity cannot be null");
		}
		if(!Pattern.matches(RegularExpression.number, productQuantity)) {
			throw new ValidationException(102l, "Product Quantity id is not valid");
		}
		
	}

	@Override
	public void checkId(String orderId) {
		if(orderId == null || orderId.isEmpty()) {
			throw new ValidationException(101l, "Order id cannot be null");
		}
		if(!Pattern.matches(RegularExpression.number, orderId)) {
			throw new ValidationException(102l, "Order id is not valid");
		}
		
	}

}
