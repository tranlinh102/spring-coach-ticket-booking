package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.model.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.model.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.model.entity.Vehicle;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IVehicleService extends IBaseService<Vehicle, UUID> {
    List<VehicleResponseDto> findAllDto();
    VehicleResponseDto findByIdDto(UUID id);
    VehicleResponseDto createVehicle(VehicleRequestDto requestDto);
    VehicleResponseDto updateVehicle(UUID id, VehicleRequestDto requestDto);
}
