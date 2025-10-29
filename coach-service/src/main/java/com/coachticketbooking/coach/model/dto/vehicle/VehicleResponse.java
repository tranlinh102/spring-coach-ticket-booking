package com.coachticketbooking.coach.model.dto.vehicle;

import com.coachticketbooking.coach.model.enums.VehicleStatus;
import com.coachticketbooking.coach.model.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.UUID;

public record VehicleResponse (
    UUID id,
    String licensePlate,
    Integer seatCapacity,
    VehicleType type,
    VehicleStatus status,
    LocalDateTime createdAt
) {}
