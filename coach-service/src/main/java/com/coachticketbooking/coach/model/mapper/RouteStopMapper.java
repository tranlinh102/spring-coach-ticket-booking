package com.coachticketbooking.coach.model.mapper;

import com.coachticketbooking.coach.model.dto.routestop.RouteStopRequestDto;
import com.coachticketbooking.coach.model.dto.routestop.RouteStopResponseDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.model.entity.RouteStop;
import com.coachticketbooking.coach.model.entity.RouteStopId;
import com.coachticketbooking.coach.model.entity.Stop;
import org.springframework.stereotype.Component;

@Component
public class RouteStopMapper {

    public RouteStopResponseDto toDto(RouteStop entity) {
        if (entity == null) return null;

        RouteStopResponseDto dto = new RouteStopResponseDto();
        dto.setRouteId(entity.getRoute() != null ? entity.getRoute().getId() : null);
        dto.setStopId(entity.getStop() != null ? entity.getStop().getId() : null);
        dto.setStopOrder(entity.getStopOrder());
        dto.setBusStation(entity.isBusStation());
        dto.setAllowPickup(entity.isAllowPickup());
        dto.setAllowDropoff(entity.isAllowDropoff());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public RouteStop toEntity(RouteStopRequestDto dto, Route route, Stop stop) {
        if (dto == null) return null;

        RouteStop entity = new RouteStop();
        RouteStopId id = new RouteStopId(
            dto.getRouteId(),
            dto.getStopId()
        );
        entity.setId(id);
        entity.setRoute(route);
        entity.setStop(stop);
        entity.setStopOrder(dto.getStopOrder());
        entity.setBusStation(dto.isBusStation());
        entity.setAllowPickup(dto.isAllowPickup());
        entity.setAllowDropoff(dto.isAllowDropoff());
        return entity;
    }

    public void updateEntity(RouteStopRequestDto dto, RouteStop entity) {
        if (dto == null || entity == null) return;

        entity.setStopOrder(dto.getStopOrder());
        entity.setBusStation(dto.isBusStation());
        entity.setAllowPickup(dto.isAllowPickup());
        entity.setAllowDropoff(dto.isAllowDropoff());
    }
}

