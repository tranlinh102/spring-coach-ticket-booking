package com.coachticketbooking.coach.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SeatStatus {
    ACTIVE("Hoạt động"),
    INACTIVE("Không hoạt động"),
    MAINTENANCE("Bảo trì");

    private final String label;

    SeatStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
