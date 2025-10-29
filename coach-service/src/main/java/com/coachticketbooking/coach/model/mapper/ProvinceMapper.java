package com.coachticketbooking.coach.model.mapper;

import com.coachticketbooking.coach.model.dto.province.ProvinceRequestDto;
import com.coachticketbooking.coach.model.dto.province.ProvinceResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import org.springframework.stereotype.Component;

@Component
public class ProvinceMapper {

    public ProvinceResponseDto toDto(Province entity) {
        if (entity == null) return null;

        ProvinceResponseDto dto = new ProvinceResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Province toEntity(ProvinceRequestDto dto) {
        if (dto == null) return null;

        Province entity = new Province();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        return entity;
    }

    public void updateEntity(ProvinceRequestDto dto, Province entity) {
        if (dto == null || entity == null) return;

        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
    }
}

