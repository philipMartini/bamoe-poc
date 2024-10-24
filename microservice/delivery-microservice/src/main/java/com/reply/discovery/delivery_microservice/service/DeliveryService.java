package com.reply.discovery.delivery_microservice.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.discovery.autogen.backends.bamoe.generic.BamoeBackendApi;
import com.reply.discovery.delivery_microservice.service.mapper.DeliveryMapper;

import it.reply.discovery.integration.delivery.model.StartDeliveryProcessRequest;

@Service
public class DeliveryService {

	private DeliveryMapper mapper;
	private BamoeBackendApi processInstancesApi;

	@Autowired
	public DeliveryService(DeliveryMapper mapper, BamoeBackendApi processInstanceApi)
	{
		this.mapper = mapper;
		this.processInstancesApi = processInstanceApi;
	}
	
	public void createDeliveryOrder(StartDeliveryProcessRequest request)
	{
		Map<String,Object> body = mapper.createBamoeStartProcessRequestBody(request);
		processInstancesApi.startProcess("poc_datamodel_v1_1.0.0-SNAPSHOT", "poc_datamodel_v1.ProcessDelivery_with_datamodel", body);
	}
}
