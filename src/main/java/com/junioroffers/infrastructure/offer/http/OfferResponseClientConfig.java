package com.junioroffers.infrastructure.offer.http;

import com.junioroffers.domain.offer.OfferResponsable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class OfferResponseClientConfig {
    @Bean
    public RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(@Value("${job-offers.offer-response.http.client.config.connectionTimeout}") int connectionTimeout,
                                     @Value("${job-offers.offer-response.http.client.config.readTimeout}") long readTimeout,
                                     RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(restTemplateResponseErrorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }

    @Bean
    public OfferResponsable remoteOfferResponseClient(RestTemplate restTemplate,
                                                      @Value("${job-offers.offer-response.http.client.config.uri}") String uri){
        return new OfferResponseRestTemplate(uri,restTemplate);
    }


}
