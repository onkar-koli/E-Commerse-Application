package com.order.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EcomResponce {
	
	String successMessage;
	
	String errorCode;
	
	String errorMessage;
	
	Object obj;

}
