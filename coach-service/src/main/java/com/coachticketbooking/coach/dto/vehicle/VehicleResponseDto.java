package com.coachticketbooking.coach.dto.vehicle;

import com.coachticketbooking.coach.model.enums.VehicleStatus;
import com.coachticketbooking.coach.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDto {
    private UUID id;
    private String licensePlate;
    private Integer seatCapacity;
    private Integer activeSeatCount;
    private VehicleType type;
    private VehicleStatus status;
    private boolean active;
}

