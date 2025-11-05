package com.coachticketbooking.coach.mapper;

import com.coachticketbooking.coach.dto.route.RouteResponseDto;
import com.coachticketbooking.coach.dto.trip.TripResponseDto;
import com.coachticketbooking.coach.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.dto.trip.TripRequestDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.model.entity.Trip;
import com.coachticketbooking.coach.model.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripResponseDto toDto(Trip entity) {
        if (entity == null) return null;

        TripResponseDto dto = new TripResponseDto();
        dto.setId(entity.getId());
        dto.setRouteId(entity.getRoute() != null ? entity.getRoute().getId() : null);
        dto.setVehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null);
        dto.setDriver(entity.getDriver());
        dto.setScheduledDepartureTime(entity.getScheduledDepartureTime());
        dto.setScheduledArrivalTime(entity.getScheduledArrivalTime());
        dto.setActualDepartureTime(entity.getActualDepartureTime());
        dto.setActualArrivalTime(entity.getActualArrivalTime());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus());
        dto.setNote(entity.getNote());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        // Map nested vehicle
        Vehicle vehicle = entity.getVehicle();
        if (vehicle != null) {
            VehicleResponseDto v = new VehicleResponseDto();
            v.setId(vehicle.getId());
            v.setLicensePlate(vehicle.getLicensePlate());
            v.setSeatCapacity(vehicle.getSeatCapacity());
            v.setActiveSeatCount(vehicle.getActiveSeatCount());
            v.setType(vehicle.getType());
            v.setStatus(vehicle.getStatus());
            v.setActive(vehicle.isActive());
            dto.setVehicle(v);
        }

        // Map nested route
        Route route = entity.getRoute();
        if (route != null) {
            RouteResponseDto r = new RouteResponseDto();
            r.setId(route.getId());
            r.setCode(route.getCode());
            r.setName(route.getName());
            r.setStartStopId(route.getStartStop() != null ? route.getStartStop().getId() : null);
            r.setEndStopId(route.getEndStop() != null ? route.getEndStop().getId() : null);
            r.setDistanceKm(route.getDistanceKm());
            r.setEstimatedDurationMinutes(route.getEstimatedDurationMinutes());
            r.setActive(route.isActive());
            r.setCreatedAt(route.getCreatedAt());
            r.setUpdatedAt(route.getUpdatedAt());
            dto.setRoute(r);
        }

        return dto;
    }

    public Trip toEntity(TripRequestDto dto, Route route, Vehicle vehicle) {
        if (dto == null) return null;

        Trip entity = new Trip();
        entity.setRoute(route);
        entity.setVehicle(vehicle);
        entity.setDriver(dto.getDriver());
        entity.setScheduledDepartureTime(dto.getScheduledDepartureTime());
        entity.setScheduledArrivalTime(dto.getScheduledArrivalTime());
        entity.setPrice(dto.getPrice());
        entity.setNote(dto.getNote());
        return entity;
    }

    public void updateEntity(TripRequestDto dto, Trip entity, Route route, Vehicle vehicle) {
        if (dto == null || entity == null) return;

        if (route != null) {
            entity.setRoute(route);
        }
        if (vehicle != null) {
            entity.setVehicle(vehicle);
        }
        entity.setDriver(dto.getDriver());
        entity.setScheduledDepartureTime(dto.getScheduledDepartureTime());
        entity.setScheduledArrivalTime(dto.getScheduledArrivalTime());
        entity.setPrice(dto.getPrice());
        entity.setNote(dto.getNote());
    }
}
