package com.coachticketbooking.coach.model.dto.routestop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteStopResponseDto {
    private UUID routeId;
    private UUID stopId;
    private Integer stopOrder;
    private boolean isBusStation;
    private boolean allowPickup;
    private boolean allowDropoff;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

