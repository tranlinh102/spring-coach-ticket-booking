package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.model.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.model.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.model.entity.Vehicle;
import com.coachticketbooking.coach.model.mapper.VehicleMapper;
import com.coachticketbooking.coach.repository.VehicleRepository;
import com.coachticketbooking.coach.service.IVehicleService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService extends BaseService<Vehicle, UUID> implements IVehicleService {

    private final VehicleMapper vehicleMapper;
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository repository, VehicleMapper vehicleMapper) {
        super(repository);
        this.vehicleRepository = repository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleResponseDto> findAllDto() {
        return findAll().stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(vehicleMapper::toDto)
                .orElse(null);
    }

    @Override
    public VehicleResponseDto createVehicle(VehicleRequestDto requestDto) {
        Vehicle vehicle = vehicleMapper.toEntity(requestDto);
        Vehicle saved = save(vehicle);
        return vehicleMapper.toDto(saved);
    }

    @Override
    public VehicleResponseDto updateVehicle(UUID id, VehicleRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    vehicleMapper.updateEntity(requestDto, existing);
                    Vehicle updated = save(existing);
                    return vehicleMapper.toDto(updated);
                })
                .orElse(null);
    }
}
