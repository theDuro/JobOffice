package com.example.jobOfice.domain.offer;

public enum TypeOfJob {
    HYBRID("Hybrid"),
    REMOTE("Remote"),
    ONSITE("OnSite");

    private final String value;

    TypeOfJob(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
