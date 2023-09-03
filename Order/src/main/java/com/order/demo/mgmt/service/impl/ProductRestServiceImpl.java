package com.order.demo.mgmt.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.demo.mgmt.service.ProductRestService;
import com.order.demo.model.EcomResponce;

@Service("productRestService")
public class ProductRestServiceImpl implements ProductRestService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<EcomResponce> getByProductId(String productId) throws Exception {
		URI uri = new URI("http://product/product/getbyid?productId="+productId);
		return (ResponseEntity<EcomResponce>) restTemplate.getForEntity(uri, EcomResponce.class);
	}

}
