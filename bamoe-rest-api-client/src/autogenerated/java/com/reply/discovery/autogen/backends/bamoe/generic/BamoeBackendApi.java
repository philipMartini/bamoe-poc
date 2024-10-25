package com.reply.discovery.autogen.backends.bamoe.generic;

import com.reply.discovery.autogen.backends.bamoe.ApiClient;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@Component("com.reply.discovery.autogen.backends.bamoe.generic.BamoeBackendApi")
public class BamoeBackendApi {
    private ApiClient apiClient;

    public BamoeBackendApi() {
        this(new ApiClient());
    }

    @Autowired
    public BamoeBackendApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Starts a new process instance of a specified process
     * Starts a new process instance within the given container.
     * <p><b>201</b> - Process instance successfully started.
     * <p><b>500</b> - Unexpected error occurred.
     * <p><b>404</b> - Process ID or Container ID not found.
     * <p><b>403</b> - User does not have permission to access this resource.
     * @param containerId ID of the container where the process definition resides. (required)
     * @param processId ID of the process to be started. (required)
     * @param requestBody  (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void startProcess(String containerId, String processId, Map<String, Object> requestBody) throws RestClientException {
        startProcessWithHttpInfo(containerId, processId, requestBody);
    }

    /**
     * Starts a new process instance of a specified process
     * Starts a new process instance within the given container.
     * <p><b>201</b> - Process instance successfully started.
     * <p><b>500</b> - Unexpected error occurred.
     * <p><b>404</b> - Process ID or Container ID not found.
     * <p><b>403</b> - User does not have permission to access this resource.
     * @param containerId ID of the container where the process definition resides. (required)
     * @param processId ID of the process to be started. (required)
     * @param requestBody  (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> startProcessWithHttpInfo(String containerId, String processId, Map<String, Object> requestBody) throws RestClientException {
        Object postBody = requestBody;
        
        // verify the required parameter 'containerId' is set
        if (containerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'containerId' when calling startProcess");
        }
        
        // verify the required parameter 'processId' is set
        if (processId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'processId' when calling startProcess");
        }
        
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestBody' when calling startProcess");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("containerId", containerId);
        uriVariables.put("processId", processId);
        String path = apiClient.expandPath("/server/containers/{containerId}/processes/{processId}/instances", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
}
