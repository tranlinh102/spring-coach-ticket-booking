package com.coachticketbooking.coach.mapper;

import com.coachticketbooking.coach.dto.seat.SeatRequestDto;
import com.coachticketbooking.coach.dto.seat.SeatResponseDto;
import com.coachticketbooking.coach.model.entity.Seat;
import com.coachticketbooking.coach.model.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public SeatResponseDto toDto(Seat entity) {
        if (entity == null) return null;

        SeatResponseDto dto = new SeatResponseDto();
        dto.setId(entity.getId());
        dto.setVehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null);
        dto.setSeatCode(entity.getSeatCode());
        dto.setDeckNumber(entity.getDeckNumber());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Seat toEntity(SeatRequestDto dto, Vehicle vehicle) {
        if (dto == null) return null;

        Seat entity = new Seat();
        entity.setVehicle(vehicle);
        entity.setSeatCode(dto.getSeatCode());
        entity.setDeckNumber(dto.getDeckNumber());
        return entity;
    }

    public void updateEntity(SeatRequestDto dto, Seat entity, Vehicle vehicle) {
        if (dto == null || entity == null) return;

        if (vehicle != null) {
            entity.setVehicle(vehicle);
        }
        entity.setSeatCode(dto.getSeatCode());
        entity.setDeckNumber(dto.getDeckNumber());
    }
}

