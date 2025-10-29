package com.coachticketbooking.coach.model.dto.stop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopRequestDto {
    private String name;
    private String address;
    private UUID provinceId;
    private UUID wardId;
    private boolean isBusStation;
    private boolean allowPickup;
    private boolean allowDropoff;
}

