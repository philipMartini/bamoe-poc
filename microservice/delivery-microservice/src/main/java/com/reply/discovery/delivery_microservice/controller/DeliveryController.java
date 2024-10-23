package com.reply.discovery.delivery_microservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reply.discovery.delivery_microservice.Endpoints;
import com.reply.discovery.delivery_microservice.Headers;
import com.reply.discovery.delivery_microservice.service.DeliveryService;

import it.reply.discovery.integration.delivery.model.StartDeliveryProcessRequest;

@Validated
@RestController
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PostMapping(value = Endpoints.CREATE_DELIVERY_ORDER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createDeliveryOrder(@Valid @RequestBody(required = true)  StartDeliveryProcessRequest request,
							        @RequestHeader(required = true, name = Headers.SENDER) String sender,
							        @RequestHeader(required = true, name = Headers.SENDER_TRANSACTION_ID) String senderTID,
								    @RequestHeader(required = true, name = Headers.SENDER_TRANSACTION_DATETIME) String senderTDT)
	{
		deliveryService.createDeliveryOrder(request);
	}
}
