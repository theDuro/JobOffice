package com.junioroffers.infrastructure.offer.http;

import com.junioroffers.domain.offer.OfferResponsable;
import com.junioroffers.domain.offer.dto.JobOfferResponse;
import com.junioroffers.domain.offer.dto.JobOffersResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Log4j2
@AllArgsConstructor
public class OfferResponseRestTemplate implements OfferResponsable {
    private final String  URL; //= "http://ec2-3-120-147-150.eu-central-1.compute.amazonaws.com:5057/offers";
    private final RestTemplate restTemplate;



    private ResponseEntity<List<JobOfferResponse>> makeGetRequest( HttpEntity<HttpHeaders> requestEntity) {

        ResponseEntity<List<JobOfferResponse>> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        return response;
    }

    @Override
    public JobOffersResponse getOffers() {

        HttpHeaders headers = new HttpHeaders();
        final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
        try {
            final ResponseEntity<List<JobOfferResponse>> response = makeGetRequest(requestEntity);

            return JobOffersResponse.builder()
                    .offers(response.getBody())
                    .build();
        } catch (ResourceAccessException e) {

            return JobOffersResponse.builder()
                    .build();
        }
    }
}
