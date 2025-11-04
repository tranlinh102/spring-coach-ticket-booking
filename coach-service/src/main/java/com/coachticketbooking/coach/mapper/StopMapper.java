package com.coachticketbooking.coach.mapper;

import com.coachticketbooking.coach.dto.stop.StopRequestDto;
import com.coachticketbooking.coach.dto.stop.StopResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.model.entity.Ward;
import org.springframework.stereotype.Component;

@Component
public class StopMapper {

    public StopResponseDto toDto(Stop entity) {
        if (entity == null) return null;

        StopResponseDto dto = new StopResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setProvinceId(entity.getProvince() != null ? entity.getProvince().getId() : null);
        dto.setWardId(entity.getWard() != null ? entity.getWard().getId() : null);
        dto.setBusStation(entity.isBusStation());
        dto.setAllowPickup(entity.isAllowPickup());
        dto.setAllowDropoff(entity.isAllowDropoff());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Stop toEntity(StopRequestDto dto, Province province, Ward ward) {
        if (dto == null) return null;

        Stop entity = new Stop();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setProvince(province);
        entity.setWard(ward);
        entity.setBusStation(dto.isBusStation());
        entity.setAllowPickup(dto.isAllowPickup());
        entity.setAllowDropoff(dto.isAllowDropoff());
        return entity;
    }

    public void updateEntity(StopRequestDto dto, Stop entity, Province province, Ward ward) {
        if (dto == null || entity == null) return;

        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        if (province != null) {
            entity.setProvince(province);
        }
        if (ward != null) {
            entity.setWard(ward);
        }
        entity.setBusStation(dto.isBusStation());
        entity.setAllowPickup(dto.isAllowPickup());
        entity.setAllowDropoff(dto.isAllowDropoff());
    }
}

