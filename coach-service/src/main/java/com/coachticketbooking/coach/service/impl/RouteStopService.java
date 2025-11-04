package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.routestop.RouteStopRequestDto;
import com.coachticketbooking.coach.dto.routestop.RouteStopResponseDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.model.entity.RouteStop;
import com.coachticketbooking.coach.model.entity.RouteStopId;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.mapper.RouteStopMapper;
import com.coachticketbooking.coach.repository.RouteStopRepository;
import com.coachticketbooking.coach.service.IRouteService;
import com.coachticketbooking.coach.service.IRouteStopService;
import com.coachticketbooking.coach.service.IStopService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RouteStopService extends BaseService<RouteStop, RouteStopId> implements IRouteStopService {

    private final RouteStopMapper routeStopMapper;
    private final IRouteService routeService;
    private final IStopService stopService;
    private final RouteStopRepository routeStopRepository;

    public RouteStopService(RouteStopRepository repository, RouteStopMapper routeStopMapper,
                           IRouteService routeService, IStopService stopService) {
        super(repository);
        this.routeStopRepository = repository;
        this.routeStopMapper = routeStopMapper;
        this.routeService = routeService;
        this.stopService = stopService;
    }

    @Override
    public List<RouteStopResponseDto> findAllDto() {
        return findAll().stream()
                .map(routeStopMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteStopResponseDto findByIdDto(UUID routeId, UUID stopId) {
        RouteStopId id = new RouteStopId(routeId, stopId);
        return findById(id)
                .map(routeStopMapper::toDto)
                .orElse(null);
    }

    @Override
    public RouteStopResponseDto createRouteStop(RouteStopRequestDto requestDto) {
        Route route = requestDto.getRouteId() != null ?
                routeService.findById(requestDto.getRouteId()).orElse(null) : null;
        Stop stop = requestDto.getStopId() != null ?
                stopService.findById(requestDto.getStopId()).orElse(null) : null;

        RouteStop routeStop = routeStopMapper.toEntity(requestDto, route, stop);
        RouteStop saved = save(routeStop);
        return routeStopMapper.toDto(saved);
    }

    @Override
    public RouteStopResponseDto updateRouteStop(UUID routeId, UUID stopId, RouteStopRequestDto requestDto) {
        RouteStopId id = new RouteStopId(routeId, stopId);
        return findById(id)
                .map(existing -> {
                    routeStopMapper.updateEntity(requestDto, existing);
                    RouteStop updated = save(existing);
                    return routeStopMapper.toDto(updated);
                })
                .orElse(null);
    }
}
