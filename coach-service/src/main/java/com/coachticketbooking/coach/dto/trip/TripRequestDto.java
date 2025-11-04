package com.coachticketbooking.coach.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripRequestDto {
    private UUID routeId;
    private UUID vehicleId;
    private UUID driver;
    private LocalDateTime scheduledDepartureTime;
    private LocalDateTime scheduledArrivalTime;
    private BigDecimal price;
    private String note;
}

