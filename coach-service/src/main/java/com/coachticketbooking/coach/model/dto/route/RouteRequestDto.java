package com.coachticketbooking.coach.model.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequestDto {
    private String code;
    private String name;
    private UUID startStopId;
    private UUID endStopId;
    private Double distanceKm;
    private Integer estimatedDurationMinutes;
}

