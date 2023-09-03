package com.product.demo.mgmt.validator.offlinevalidation;

public interface OfflineValidator {
	
	void checkName(String bookName);

	void checkDescription(String description);
		
	void checkPrice(String price);

	void checkId(String productId);

}
