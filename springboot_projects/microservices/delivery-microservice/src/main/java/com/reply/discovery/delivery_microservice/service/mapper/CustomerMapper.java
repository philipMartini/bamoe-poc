package com.reply.discovery.delivery_microservice.service.mapper;

import org.springframework.stereotype.Component;

import it.reply.discovery.integration.delivery.model.AddressObject;
import it.reply.discovery.integration.delivery.model.CustomerObject;
import it.reply.discovery.integration.delivery.model.CustomerObject.CustomerTypeEnum;

@Component
public class CustomerMapper {
	
	public CustomerObject createCustomerInfoRespose() {
		CustomerObject customerObject = new CustomerObject();
		
		customerObject.setSurname("Bernardo");
		customerObject.setName("Mario");
		customerObject.setBadPayer(true);
		customerObject.setCustomerType(CustomerTypeEnum.RESIDENTIAL);
		
		AddressObject addressObject = new AddressObject();
		addressObject.setCity("Colleferro");
		addressObject.setStreet("Via dei monti");
		addressObject.setStreetNumber(33);
		addressObject.setZipCode("0000");
		
		customerObject.setAddress(addressObject);
		return customerObject;
	}
}
