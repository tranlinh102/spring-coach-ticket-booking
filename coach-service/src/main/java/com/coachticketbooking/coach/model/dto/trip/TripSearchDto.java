package com.coachticketbooking.coach.model.dto.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TripSearchDto {
    UUID getTripId();
    LocalDateTime getScheduledDepartureTime();
    String getStartAddress();
    String getEndAddress();
    String getVehicleType();
    Integer getActiveSeatCount();
    Integer getAvailableSeats();
}