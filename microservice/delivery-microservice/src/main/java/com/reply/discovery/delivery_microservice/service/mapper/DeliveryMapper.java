package com.reply.discovery.delivery_microservice.service.mapper;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.reply.discovery.autogen.backends.bamoe.generic.ProcessParameters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.reply.discovery.integration.delivery.model.DeliveryAppointmentCallback;
import it.reply.discovery.integration.delivery.model.StartDeliveryProcessRequest;

@Component
public class DeliveryMapper {
	
	public Map<String,Object> createBamoeStartProcessRequestBody(StartDeliveryProcessRequest request) {
		Map<String,Object> requestMap = new HashMap<>();
		
		/*/
		Map<String,Object> processParameters = new HashMap<>();
		boolean a = (processParameters.containsKey("APIWithAsyncCallback") && ((Boolean)(processParameters.get("APIWithAsyncCallback"))).equals(true));
		boolean b = (processParameters.containsKey("APIWithAsyncCallback") && ((String)(processParameters.get("APIWithAsyncCallback"))).equals("true"));

		if(processParameters.containsKey("APIWithAsyncCallback")){
		    System.out.println("APIWithAsyncCallback:" + processParameters.get("APIWithAsyncCallback") + "--- classType" + processParameters.get("APIWithAsyncCallback").getClass());
		}

		
		//*/
		/*/
		boolean a = (requestMap.containsKey("APIWithAsyncCallback") && ((boolean)(requestMap.get("APIWithAsyncCallback")))==true);
		boolean b = ((String)(requestMap.get("APIWithAsyncCallback"))).equals("true");
		boolean c = ((boolean)(requestMap.get("APIWithAsyncCallback")))==true;
		boolean d = (requestMap.containsKey("APIWithAsyncCallback") && ((String)requestMap.get("APIWithAsyncCallback")==true));
		//*/
		
		ProcessParameters processParameters = new ProcessParameters();
		processParameters.setApIUrl("http://192.168.178.102:8088/customers/" + request.getCustomerId());
		processParameters.setApIWithAsyncCallback(false);
		requestMap.put("processRequest", request);
		requestMap.put("processParameters", processParameters);
		//JSONObject jsonObject = new JSONObject(requestMap);
		return requestMap; //jsonObject.toString();
	}
	
	public Map<String,Object> createBamoeSendMessageRequestBody(DeliveryAppointmentCallback request) {
		ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.convertValue(request, new TypeReference<Map<String, Object>>() {});
	}
}
