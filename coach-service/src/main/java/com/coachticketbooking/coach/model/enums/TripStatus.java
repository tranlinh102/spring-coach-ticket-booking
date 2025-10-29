package com.coachticketbooking.coach.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TripStatus {
    SCHEDULED("Đã lên lịch"),
    ONGOING("Đang chạy"),
    DELAYED("Trì hoãn"),
    COMPLETED("Hoàn thành"),
    CANCELLED("Đã hủy");

    private final String label;

    TripStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
