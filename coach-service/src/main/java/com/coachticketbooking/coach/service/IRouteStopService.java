package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.dto.routestop.RouteStopRequestDto;
import com.coachticketbooking.coach.dto.routestop.RouteStopResponseDto;
import com.coachticketbooking.coach.model.entity.RouteStop;
import com.coachticketbooking.coach.model.entity.RouteStopId;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IRouteStopService extends IBaseService<RouteStop, RouteStopId> {
    List<RouteStopResponseDto> findAllDto();
    RouteStopResponseDto findByIdDto(UUID routeId, UUID stopId);
    RouteStopResponseDto createRouteStop(RouteStopRequestDto requestDto);
    RouteStopResponseDto updateRouteStop(UUID routeId, UUID stopId, RouteStopRequestDto requestDto);
}
