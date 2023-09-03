package com.product.demo.mgmt.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.demo.mgmt.exception.ValidationException;
import com.product.demo.mgmt.service.EcomResponceService;
import com.product.demo.model.EcomResponce;

@Service("ecomResponceService")
public class EcomResponceServiceImpl implements EcomResponceService {

	@Override
	public ResponseEntity<?> getSuccesResponce(Object object) {
		EcomResponce responce = new EcomResponce();
		responce.setSuccessMessage("SUCCESS");
		responce.setObj(object);
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getUncheckedExceptionResponce(ValidationException e) {
		EcomResponce responce = new EcomResponce();
		responce.setErrorCode(e.getErrorCode().toString());
		responce.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getCheckedExceptionResponce(Exception e) {
		EcomResponce responce = new EcomResponce();
		responce.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(responce, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
