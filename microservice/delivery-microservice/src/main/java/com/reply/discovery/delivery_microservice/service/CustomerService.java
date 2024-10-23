package com.reply.discovery.delivery_microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.discovery.delivery_microservice.service.mapper.CustomerMapper;
import it.reply.discovery.integration.delivery.model.CustomerObject;


@Service
public class CustomerService {

	private CustomerMapper mapper;
	
	@Autowired
	public CustomerService(CustomerMapper mapper)
	{
		this.mapper = mapper;
	}
	
	public CustomerObject getCustomer(int customerId)
	{
		return mapper.createCustomerInfoRespose();
	}
}
