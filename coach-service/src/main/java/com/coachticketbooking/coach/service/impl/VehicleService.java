package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.exception.DuplicateResourceException;
import com.coachticketbooking.coach.exception.ResourceNotFoundException;
import com.coachticketbooking.coach.model.entity.Vehicle;
import com.coachticketbooking.coach.mapper.VehicleMapper;
import com.coachticketbooking.coach.repository.VehicleRepository;
import com.coachticketbooking.coach.service.IVehicleService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<VehicleResponseDto> findAllDto(Pageable pageable) {
        Page<Vehicle> page = vehicleRepository.findAll(pageable);
        List<VehicleResponseDto> dtos = page.getContent().stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @Override
    public Page<VehicleResponseDto> findAllDto(String keyword, Boolean active, Pageable pageable) {
        Page<Vehicle> page;

        boolean hasKeyword = keyword != null && !keyword.trim().isEmpty();
        boolean hasActiveFilter = active != null;

        if (hasKeyword && hasActiveFilter) {
            page = vehicleRepository.findByLicensePlateContainingIgnoreCaseAndActive(keyword.trim(), active, pageable);
        } else if (hasKeyword) {
            page = vehicleRepository.findByLicensePlateContainingIgnoreCase(keyword.trim(), pageable);
        } else if (hasActiveFilter) {
            page = vehicleRepository.findByActive(active, pageable);
        } else {
            page = vehicleRepository.findAll(pageable);
        }

        List<VehicleResponseDto> dtos = page.getContent().stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @Override
    public VehicleResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(vehicleMapper::toDto)
                .orElse(null);
    }

    @Override
    public VehicleResponseDto createVehicle(VehicleRequestDto requestDto) {
        // Check if license plate already exists
        if (vehicleRepository.findByLicensePlate(requestDto.getLicensePlate()).isPresent()) {
            throw new DuplicateResourceException(
                    "Vehicle with license plate '" + requestDto.getLicensePlate() + "' already exists"
            );
        }

        Vehicle vehicle = vehicleMapper.toEntity(requestDto);
        Vehicle saved = save(vehicle);
        return vehicleMapper.toDto(saved);
    }

    @Override
    public VehicleResponseDto updateVehicle(UUID id, VehicleRequestDto requestDto) {
        Vehicle existing = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));

        // Check if the new license plate is already used by another vehicle
        if (!existing.getLicensePlate().equals(requestDto.getLicensePlate())) {
            vehicleRepository.findByLicensePlate(requestDto.getLicensePlate())
                    .ifPresent(v -> {
                        throw new DuplicateResourceException(
                                "Vehicle with license plate '" + requestDto.getLicensePlate() + "' already exists"
                        );
                    });
        }

        vehicleMapper.updateEntity(requestDto, existing);
        Vehicle updated = save(existing);
        return vehicleMapper.toDto(updated);
    }

    @Override
    public VehicleResponseDto changeActive(UUID id) {
        Vehicle vehicle = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));

        vehicle.setActive(!vehicle.isActive());
        Vehicle updated = save(vehicle);
        return vehicleMapper.toDto(updated);
    }
}
