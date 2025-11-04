package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.trip.TripRequestDto;
import com.coachticketbooking.coach.dto.trip.TripResponseDto;
import com.coachticketbooking.coach.dto.trip.TripSearchDto;
import com.coachticketbooking.coach.model.entity.Route;
import com.coachticketbooking.coach.model.entity.Trip;
import com.coachticketbooking.coach.model.entity.Vehicle;
import com.coachticketbooking.coach.mapper.TripMapper;
import com.coachticketbooking.coach.repository.TripRepository;
import com.coachticketbooking.coach.service.IRouteService;
import com.coachticketbooking.coach.service.ITripService;
import com.coachticketbooking.coach.service.IVehicleService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TripService extends BaseService<Trip, UUID> implements ITripService {

    private final TripMapper tripMapper;
    private final IRouteService routeService;
    private final IVehicleService vehicleService;
    private final TripRepository tripRepository;

    public TripService(TripRepository repository, TripMapper tripMapper,
                      IRouteService routeService, IVehicleService vehicleService) {
        super(repository);
        this.tripRepository = repository;
        this.tripMapper = tripMapper;
        this.routeService = routeService;
        this.vehicleService = vehicleService;
    }

    @Override
    public List<TripResponseDto> findAllDto() {
        return findAll().stream()
                .map(tripMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TripResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(tripMapper::toDto)
                .orElse(null);
    }

    @Override
    public TripResponseDto createTrip(TripRequestDto requestDto) {
        Route route = requestDto.getRouteId() != null ?
                routeService.findById(requestDto.getRouteId()).orElse(null) : null;
        Vehicle vehicle = requestDto.getVehicleId() != null ?
                vehicleService.findById(requestDto.getVehicleId()).orElse(null) : null;

        Trip trip = tripMapper.toEntity(requestDto, route, vehicle);
        Trip saved = save(trip);
        return tripMapper.toDto(saved);
    }

    @Override
    public TripResponseDto updateTrip(UUID id, TripRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Route route = requestDto.getRouteId() != null ?
                            routeService.findById(requestDto.getRouteId()).orElse(null) : null;
                    Vehicle vehicle = requestDto.getVehicleId() != null ?
                            vehicleService.findById(requestDto.getVehicleId()).orElse(null) : null;

                    tripMapper.updateEntity(requestDto, existing, route, vehicle);
                    Trip updated = save(existing);
                    return tripMapper.toDto(updated);
                })
                .orElse(null);
    }

    @Override
    public List<TripSearchDto> searchTrips(LocalDate departureDate, UUID startProvinceId, UUID endProvinceId, Integer requiredSeats) {
        return tripRepository.searchTrips(departureDate, startProvinceId, endProvinceId, requiredSeats);
    }
}
