package com.coachticketbooking.coach.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookingDetailStatus {
    BOOKED("Đã đặt"),
    CANCELLED("Đã hủy"),
    CHECKED_IN("Đã làm thủ tục"),
    USED("Đã sử dụng");

    private final String label;

    BookingDetailStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
