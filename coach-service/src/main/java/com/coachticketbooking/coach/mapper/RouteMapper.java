package com.coachticketbooking.coach.mapper;

import com.coachticketbooking.coach.dto.route.RouteRequestDto;
import com.coachticketbooking.coach.dto.route.RouteResponseDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.model.entity.Stop;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public RouteResponseDto toDto(Route entity) {
        if (entity == null) return null;

        RouteResponseDto dto = new RouteResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStartStopId(entity.getStartStop() != null ? entity.getStartStop().getId() : null);
        dto.setEndStopId(entity.getEndStop() != null ? entity.getEndStop().getId() : null);
        dto.setDistanceKm(entity.getDistanceKm());
        dto.setEstimatedDurationMinutes(entity.getEstimatedDurationMinutes());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Route toEntity(RouteRequestDto dto, Stop startStop, Stop endStop) {
        if (dto == null) return null;

        Route entity = new Route();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStartStop(startStop);
        entity.setEndStop(endStop);
        entity.setDistanceKm(dto.getDistanceKm());
        entity.setEstimatedDurationMinutes(dto.getEstimatedDurationMinutes());
        return entity;
    }

    public void updateEntity(RouteRequestDto dto, Route entity, Stop startStop, Stop endStop) {
        if (dto == null || entity == null) return;

        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        if (startStop != null) {
            entity.setStartStop(startStop);
        }
        if (endStop != null) {
            entity.setEndStop(endStop);
        }
        entity.setDistanceKm(dto.getDistanceKm());
        entity.setEstimatedDurationMinutes(dto.getEstimatedDurationMinutes());
    }
}

