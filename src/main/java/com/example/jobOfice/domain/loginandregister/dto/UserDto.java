package com.example.jobOfice.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserDto(String userId,String userName,String password) {
}
