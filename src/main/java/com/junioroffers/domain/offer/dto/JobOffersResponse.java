package com.junioroffers.domain.offer.dto;

import lombok.Builder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@Builder
public record JobOffersResponse(List<JobOfferResponse> offers) {
}

