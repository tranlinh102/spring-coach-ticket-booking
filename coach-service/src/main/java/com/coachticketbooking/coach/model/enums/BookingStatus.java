package com.coachticketbooking.coach.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookingStatus {
    PENDING("Đang chờ thanh toán"),
    CONFIRMED("Đã xác nhận"),
    PAID("Đã thanh toán"),
    CANCELLED("Đã hủy"),
    COMPLETED("Đã sử dụng"),
    REFUNDED("Đã hoàn tiền");

    private final String label;

    BookingStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
