package com.reply.discovery.delivery_microservice.service.mapper;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.reply.discovery.autogen.backends.bamoe.generic.ProcessConfiguration;
import com.reply.discovery.autogen.backends.bamoe.generic.ProcessParameters;

import it.reply.discovery.integration.delivery.model.StartDeliveryProcessRequest;

@Component
public class DeliveryMapper {
	
	public Map<String,Object> createBamoeStartProcessRequestBody(StartDeliveryProcessRequest request) {
		Map<String,Object> requestMap = new HashMap<>();
		
		ProcessParameters processParameters = new ProcessParameters();
		processParameters.setApIurl("http://192.168.178.102:8088/customers/" + request.getCustomerId());
		requestMap.put("processRequest", request);
		requestMap.put("processParameters", processParameters);
		//JSONObject jsonObject = new JSONObject(requestMap);
		return requestMap; //jsonObject.toString();
	}
}
