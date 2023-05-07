package com.example.jobOfice.domain.offer;

import com.example.jobOfice.domain.offer.dto.OferDto;

public class OferMaper {
    public static OferDto mapfromOfer(Ofer ofer){
        return OferDto.builder()
                .id(ofer.id())
                .typeOfJob(ofer.typeOfJob())
                .build();
    }
}
