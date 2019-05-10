package com.revature.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

public class RequestHeaders {

	private static final Logger logger = Logger.getLogger(RequestHeaders.class);
	public void requestHeader(final RestTemplate restTemplate) {
		
		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {

			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().set("OAuth Token", "BQCy_AtM-RM3P-DjJDpRAGJvsm2qBOVUNcC23OCZZvUXEZadA8y9bBwJpy4JMhWYCRo_qrHQJrK4ha7idhC6LAMwWtKt2TYOEznlddAtYIwW7tOWFxem0vcH_A2qi7tV0rozOncB79E_sGvvXs4KxIU");
				return execution.execute(request, body);
			}
			
		});
	}
}
