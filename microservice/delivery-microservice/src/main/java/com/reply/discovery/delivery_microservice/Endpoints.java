package com.reply.discovery.delivery_microservice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endpoints
{
	/*
	 * Endpoint that performs the creation of a Delivery Order
	 */
	public static final String CREATE_DELIVERY_ORDER_ENDPOINT = "/orders/start-delivery-process";
	public static final String GET_CUSTOMER_ENDPOINT = "/customers/{customerId}";
	public static final String CREATE_CALLBACK_CONFIRM_SCHEDULE_ENDPOINT = "/orders/confirm-schedule-delivery/{processInstanceId}";
}
