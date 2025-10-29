package com.coachticketbooking.coach.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VehicleStatus {
    ACTIVE("Hoạt động"),
    INACTIVE("Không hoạt động"),
    MAINTENANCE("Bảo trì");

    private final String label;

    VehicleStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
