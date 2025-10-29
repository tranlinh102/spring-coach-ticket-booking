package com.coachticketbooking.coach.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VehicleType {
    SEAT("Ghế"),
    BED("Giường"),
    LIMOUSINE("Limousine");

    private final String label;

    VehicleType(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
