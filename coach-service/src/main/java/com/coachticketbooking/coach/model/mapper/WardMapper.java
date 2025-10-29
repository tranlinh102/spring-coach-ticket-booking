package com.coachticketbooking.coach.model.mapper;

import com.coachticketbooking.coach.model.dto.ward.WardRequestDto;
import com.coachticketbooking.coach.model.dto.ward.WardResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import com.coachticketbooking.coach.model.entity.Ward;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WardMapper {

    public WardResponseDto toDto(Ward entity) {
        if (entity == null) return null;

        WardResponseDto dto = new WardResponseDto();
        dto.setId(entity.getId());
        dto.setProvinceId(entity.getProvince() != null ? entity.getProvince().getId() : null);
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Ward toEntity(WardRequestDto dto, Province province) {
        if (dto == null) return null;

        Ward entity = new Ward();
        entity.setProvince(province);
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        return entity;
    }

    public void updateEntity(WardRequestDto dto, Ward entity, Province province) {
        if (dto == null || entity == null) return;

        if (province != null) {
            entity.setProvince(province);
        }
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
    }
}

