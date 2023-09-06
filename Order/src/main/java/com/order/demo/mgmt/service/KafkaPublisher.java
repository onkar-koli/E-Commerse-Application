package com.order.demo.mgmt.service;

public interface KafkaPublisher {
	
	void sendMessage(String topicName, String message);

}
