package com.product.demo.mgmt.validator.offlinevalidation.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.product.demo.mgmt.exception.ValidationException;
import com.product.demo.mgmt.regularexpression.RegularExpression;
import com.product.demo.mgmt.validator.offlinevalidation.OfflineValidator;

@Service("offlineValidator")
public class OfflineValidatorImpl implements OfflineValidator {

	@Override
	public void checkName(String bookName) {
		
		if (bookName == null || bookName.isEmpty()) {
			throw new ValidationException(101l, "Product Name cannot be null");
		}
		if (!Pattern.matches(RegularExpression.azAz, bookName)) {
			throw new ValidationException(102l, "Product Name is invalid");
		}
		
	}

	@Override
	public void checkDescription(String description) {
		
		if (description == null || description.isEmpty()) {
			throw new ValidationException(101l, "Product Description cannot be null");
		}
		if (!Pattern.matches(RegularExpression.alpha_num_special_chars, description)) {
			throw new ValidationException(102l, "Product Description is invalid");
		}
		
	}

	@Override
	public void checkPrice(String price) {
		
		if (price == null || price.isEmpty()) {
			throw new ValidationException(101l, "Product Price cannot be null");
		}
		if (!Pattern.matches(RegularExpression.number, price)) {
			throw new ValidationException(102l, "Product Price is invalid");
		}
		
	}

	@Override
	public void checkId(String productId) {
		
		if (productId == null || productId.isEmpty()) {
			throw new ValidationException(101l, "Product Id cannot be null");
		}
		if (!Pattern.matches(RegularExpression.number, productId)) {
			throw new ValidationException(102l, "Product Id is invalid");
		}

	}

}
