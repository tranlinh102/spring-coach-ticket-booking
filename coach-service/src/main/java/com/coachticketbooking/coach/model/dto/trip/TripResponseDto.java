package com.coachticketbooking.coach.model.dto.trip;

import com.coachticketbooking.coach.model.enums.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripResponseDto {
    private UUID id;
    private UUID routeId;
    private UUID vehicleId;
    private UUID driver;
    private LocalDateTime scheduledDepartureTime;
    private LocalDateTime scheduledArrivalTime;
    private LocalDateTime actualDepartureTime;
    private LocalDateTime actualArrivalTime;
    private BigDecimal price;
    private TripStatus status;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


