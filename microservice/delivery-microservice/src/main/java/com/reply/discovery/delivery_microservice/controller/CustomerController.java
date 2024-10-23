package com.reply.discovery.delivery_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reply.discovery.delivery_microservice.Constants;
import com.reply.discovery.delivery_microservice.Endpoints;
import com.reply.discovery.delivery_microservice.Headers;
import com.reply.discovery.delivery_microservice.service.CustomerService;

import it.reply.discovery.integration.delivery.model.CustomerObject;

@Validated
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = Endpoints.GET_CUSTOMER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerObject getCustomer(@PathVariable(name=Constants.CUSTOMER_ID,required=true) Integer customerId,
									@RequestHeader(required = true, name = Headers.SENDER) String sender,
							        @RequestHeader(required = true, name = Headers.SENDER_TRANSACTION_ID) String senderTID,
								    @RequestHeader(required = true, name = Headers.SENDER_TRANSACTION_DATETIME) String senderTDT)
	{
		return customerService.getCustomer(customerId);
	}
}
