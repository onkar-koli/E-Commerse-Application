package com.product.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.product.demo.mgmt.exception.ValidationException;

public interface EcomResponceService {
	
	ResponseEntity<?> getSuccesResponce(Object object);
	
	ResponseEntity<?> getUncheckedExceptionResponce(ValidationException e);
	
	ResponseEntity<?> getCheckedExceptionResponce(Exception e);

}
