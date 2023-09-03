package com.order.demo.mgmt.validator.offlinevalidation;

public interface OfflineValidator {
	
	void checkProductId(String ProductId);
	
	void checkProductQuantity(String productQuantity);

	void checkId(String orderId);

}
