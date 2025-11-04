package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.route.RouteRequestDto;
import com.coachticketbooking.coach.dto.route.RouteResponseDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.mapper.RouteMapper;
import com.coachticketbooking.coach.repository.RouteRepository;
import com.coachticketbooking.coach.service.IRouteService;
import com.coachticketbooking.coach.service.IStopService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RouteService extends BaseService<Route, UUID> implements IRouteService {

    private final RouteMapper routeMapper;
    private final IStopService stopService;
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository repository, RouteMapper routeMapper, IStopService stopService) {
        super(repository);
        this.routeRepository = repository;
        this.routeMapper = routeMapper;
        this.stopService = stopService;
    }

    @Override
    public List<RouteResponseDto> findAllDto() {
        return findAll().stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(routeMapper::toDto)
                .orElse(null);
    }

    @Override
    public RouteResponseDto createRoute(RouteRequestDto requestDto) {
        Stop startStop = requestDto.getStartStopId() != null ?
                stopService.findById(requestDto.getStartStopId()).orElse(null) : null;
        Stop endStop = requestDto.getEndStopId() != null ?
                stopService.findById(requestDto.getEndStopId()).orElse(null) : null;

        Route route = routeMapper.toEntity(requestDto, startStop, endStop);
        Route saved = save(route);
        return routeMapper.toDto(saved);
    }

    @Override
    public RouteResponseDto updateRoute(UUID id, RouteRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Stop startStop = requestDto.getStartStopId() != null ?
                            stopService.findById(requestDto.getStartStopId()).orElse(null) : null;
                    Stop endStop = requestDto.getEndStopId() != null ?
                            stopService.findById(requestDto.getEndStopId()).orElse(null) : null;

                    routeMapper.updateEntity(requestDto, existing, startStop, endStop);
                    Route updated = save(existing);
                    return routeMapper.toDto(updated);
                })
                .orElse(null);
    }
}
