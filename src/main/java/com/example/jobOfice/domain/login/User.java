package com.example.jobOfice.domain.login;

import lombok.Builder;

@Builder
record User(String id,
            String username,
            String password
) {
}
