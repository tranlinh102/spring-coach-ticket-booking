package com.coachticketbooking.coach.model.mapper;

import com.coachticketbooking.coach.model.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.model.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.model.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleResponseDto toDto(Vehicle entity) {
        if (entity == null) return null;

        VehicleResponseDto dto = new VehicleResponseDto();
        dto.setId(entity.getId());
        dto.setLicensePlate(entity.getLicensePlate());
        dto.setSeatCapacity(entity.getSeatCapacity());
        dto.setActiveSeatCount(entity.getActiveSeatCount());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Vehicle toEntity(VehicleRequestDto dto) {
        if (dto == null) return null;

        Vehicle entity = new Vehicle();
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setSeatCapacity(dto.getSeatCapacity());
        entity.setActiveSeatCount(dto.getActiveSeatCount());
        entity.setType(dto.getType());
        return entity;
    }

    public void updateEntity(VehicleRequestDto dto, Vehicle entity) {
        if (dto == null || entity == null) return;

        entity.setLicensePlate(dto.getLicensePlate());
        entity.setSeatCapacity(dto.getSeatCapacity());
        entity.setActiveSeatCount(dto.getActiveSeatCount());
        entity.setType(dto.getType());
    }
}
