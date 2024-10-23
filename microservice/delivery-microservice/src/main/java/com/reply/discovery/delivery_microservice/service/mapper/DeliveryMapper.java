package com.reply.discovery.delivery_microservice.service.mapper;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import it.reply.discovery.integration.delivery.model.StartDeliveryProcessRequest;

@Component
public class DeliveryMapper {
	
	public Map<String,Object> createBamoeStartProcessRequestBody(StartDeliveryProcessRequest request) {
		Map<String,Object> requestMap = new HashMap<>();
		requestMap.put("processRequest", request);
		//JSONObject jsonObject = new JSONObject(requestMap);
		return requestMap; //jsonObject.toString();
	}
}
