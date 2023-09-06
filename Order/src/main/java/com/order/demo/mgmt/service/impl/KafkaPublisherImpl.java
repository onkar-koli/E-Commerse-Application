package com.order.demo.mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.order.demo.mgmt.service.KafkaPublisher;

@Service("kafkaPublisher")
public class KafkaPublisherImpl implements KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String topicName, String message) {
		kafkaTemplate.send(topicName, message);
	}

}