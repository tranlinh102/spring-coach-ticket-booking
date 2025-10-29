package com.coachticketbooking.coach.model.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponseDto {
    private UUID id;
    private String code;
    private String name;
    private UUID startStopId;
    private UUID endStopId;
    private Double distanceKm;
    private Integer estimatedDurationMinutes;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

