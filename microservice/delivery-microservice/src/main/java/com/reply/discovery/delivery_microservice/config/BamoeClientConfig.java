package com.reply.discovery.delivery_microservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.reply.discovery.autogen.backends.bamoe.ApiClient;
import com.reply.discovery.autogen.backends.bamoe.generic.BamoeBackendApi;


@Configuration
public class BamoeClientConfig {
	/**
	 * Base URI to Bamoe
	 */
	@Value("${com.reply.discovery.config.bamoeclient.bamoeuriapi}")
	private String bamoeUri;
	/**
	 * Bamoe Connection timeout (in millis)
	 */
	@Value("${com.reply.discovery.config.bamoeclient.connectiontimeout}")
	private int connectionTimeout;
	/**
	 * Bamoe Read timeout (in millis)
	 */
	@Value("${com.reply.discovery.config.bamoeclient.readtimeout}")
	private int readTimeout;
	/**
	 * Bamoe Max number of connections
	 */
	@Value("${com.reply.discovery.config.bamoeclient.maxconnections}")
	private int maxConnections;
	/**
	 * Bamoe Max number of connections per route
	 */
	@Value("${com.reply.discovery.config.bamoeclient.maxconnectionperroute}")
	private int maxConnectionPerRoute;
	
	/**
	 * A {@link Bean} of {@link WorkOrderMaterialsApi} class, used to interrogate the OverIT/WorkOrderMaterials Api
	 *
	 * @param apiClient
	 *                  {@link ApiClient} used to perform calls
	 * @return The {@link ConfirmActivationApi}
	 */
	@Bean(name = "startProcessInstanceClient")
	public BamoeBackendApi startProcessInstanceClient(@Qualifier(value = "apiClientBamoe") ApiClient apiClient) {
		return new BamoeBackendApi(apiClient); // NOSONAR fb-contrib:WI_MANUALLY_ALLOCATING_AN_AUTOWIRED_BEAN
	}
}

