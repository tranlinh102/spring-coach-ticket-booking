package com.coachticketbooking.coach.dto.vehicle;

import com.coachticketbooking.coach.model.enums.VehicleStatus;
import com.coachticketbooking.coach.model.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleCreateRequestDto {
    private String licensePlate;
    private Integer seatCapacity;
    private VehicleType type;
    private VehicleStatus status;
}
