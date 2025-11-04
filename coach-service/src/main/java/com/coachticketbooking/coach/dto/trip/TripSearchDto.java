package com.coachticketbooking.coach.dto.trip;

import com.coachticketbooking.coach.model.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TripSearchDto {
    UUID getTripId();
    LocalDateTime getScheduledDepartureTime();
    LocalDateTime getScheduledArrivalTime();
    UUID getVehicleId();
    Double getPrice();
    String getStartStopAddress();
    String getStartStopName();
    String getEndStopAddress();
    String getEndStopName();
    VehicleType getVehicleType();
    Integer getActiveSeatCount();
    Integer getAvailableSeats();
}