package com.coachticketbooking.coach.dto.vehicle;

import com.coachticketbooking.coach.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto {
    private String licensePlate;
    private Integer seatCapacity;
    private Integer activeSeatCount;
    private VehicleType type;
}