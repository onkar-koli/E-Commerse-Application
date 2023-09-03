package com.inventory.demo.mgmt.regularexpression;

public interface RegularExpression {

	String azAz09 = "^[a-zA-Z0-9]*$";

	String number = "^[0-9]+$";

	String azAz = "^[a-zA-Z\\s]+$";
	
	String alpha_num_special_chars = "^[a-zA-Z0-9\\s!@#$%^&*()-_=+{}\\[\\]:;\"'<>,.?/|\\\\]*$";

}
