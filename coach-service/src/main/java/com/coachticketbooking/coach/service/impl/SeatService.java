package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.seat.SeatRequestDto;
import com.coachticketbooking.coach.dto.seat.SeatResponseDto;
import com.coachticketbooking.coach.model.entity.Seat;
import com.coachticketbooking.coach.model.entity.Vehicle;
import com.coachticketbooking.coach.mapper.SeatMapper;
import com.coachticketbooking.coach.repository.SeatRepository;
import com.coachticketbooking.coach.service.ISeatService;
import com.coachticketbooking.coach.service.IVehicleService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SeatService extends BaseService<Seat, UUID> implements ISeatService {

    private final SeatMapper seatMapper;
    private final IVehicleService vehicleService;
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository repository, SeatMapper seatMapper, IVehicleService vehicleService) {
        super(repository);
        this.seatRepository = repository;
        this.seatMapper = seatMapper;
        this.vehicleService = vehicleService;
    }

    @Override
    public List<SeatResponseDto> findAllDto() {
        return findAll().stream()
                .map(seatMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeatResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(seatMapper::toDto)
                .orElse(null);
    }

    @Override
    public SeatResponseDto createSeat(SeatRequestDto requestDto) {
        Vehicle vehicle = requestDto.getVehicleId() != null ?
                vehicleService.findById(requestDto.getVehicleId()).orElse(null) : null;

        Seat seat = seatMapper.toEntity(requestDto, vehicle);
        Seat saved = save(seat);
        return seatMapper.toDto(saved);
    }

    @Override
    public SeatResponseDto updateSeat(UUID id, SeatRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Vehicle vehicle = requestDto.getVehicleId() != null ?
                            vehicleService.findById(requestDto.getVehicleId()).orElse(null) : null;

                    seatMapper.updateEntity(requestDto, existing, vehicle);
                    Seat updated = save(existing);
                    return seatMapper.toDto(updated);
                })
                .orElse(null);
    }
}
