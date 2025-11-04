package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.model.entity.Vehicle;
import com.coachticketbooking.coach.service.base.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IVehicleService extends IBaseService<Vehicle, UUID> {
    List<VehicleResponseDto> findAllDto();
    Page<VehicleResponseDto> findAllDto(Pageable pageable);
    Page<VehicleResponseDto> findAllDto(String keyword, Boolean active, Pageable pageable);
    VehicleResponseDto findByIdDto(UUID id);
    VehicleResponseDto createVehicle(VehicleRequestDto requestDto);
    VehicleResponseDto updateVehicle(UUID id, VehicleRequestDto requestDto);
    VehicleResponseDto changeActive(UUID id);
}
