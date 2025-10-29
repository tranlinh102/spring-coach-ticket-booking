package com.coachticketbooking.coach.model.dto.stop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopResponseDto {
    private UUID id;
    private String name;
    private String address;
    private UUID provinceId;
    private UUID wardId;
    private boolean isBusStation;
    private boolean allowPickup;
    private boolean allowDropoff;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

