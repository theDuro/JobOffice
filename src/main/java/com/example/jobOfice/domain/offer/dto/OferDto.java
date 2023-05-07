package com.example.jobOfice.domain.offer.dto;

import com.example.jobOfice.domain.offer.TypeOfJob;
import lombok.Builder;

@Builder
public record OferDto(String id, TypeOfJob typeOfJob) {
}
