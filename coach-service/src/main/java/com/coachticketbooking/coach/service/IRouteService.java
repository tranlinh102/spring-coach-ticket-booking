package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.model.dto.route.RouteRequestDto;
import com.coachticketbooking.coach.model.dto.route.RouteResponseDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IRouteService extends IBaseService<Route, UUID> {
    List<RouteResponseDto> findAllDto();
    RouteResponseDto findByIdDto(UUID id);
    RouteResponseDto createRoute(RouteRequestDto requestDto);
    RouteResponseDto updateRoute(UUID id, RouteRequestDto requestDto);
}
