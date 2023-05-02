package fr.younes.libkafkaspring.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Log the request
        logger.info("Request URI: {} Method: {}", request.getURI(), request.getMethod());

        // Continue the request execution
        ClientHttpResponse response = execution.execute(request, body);

        // Log the response
        logger.info("Response status: {}", response.getStatusCode());

        return response;
    }
}
