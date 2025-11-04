package com.coachticketbooking.coach.dto.routestop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteStopRequestDto {
    private UUID routeId;
    private UUID stopId;
    private Integer stopOrder;
    private boolean isBusStation;
    private boolean allowPickup;
    private boolean allowDropoff;
}

