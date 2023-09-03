package com.order.demo.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.order.demo.mgmt.exception.ValidationException;

public interface EcomResponceService {
	
	ResponseEntity<?> getSuccesResponce(Object object);
	
	ResponseEntity<?> getUncheckedExceptionResponce(ValidationException e);
	
	ResponseEntity<?> getCheckedExceptionResponce(Exception e);

}
