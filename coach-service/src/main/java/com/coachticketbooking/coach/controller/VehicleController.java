package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Page<VehicleResponseDto>> getAllVehicles(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "true") boolean active,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt,desc") String sort
    ) {
        // build Sort from a single string like "field,asc" or "field,desc"
        String[] sortParts = sort.split(",");
        String sortBy = sortParts[0];
        Sort.Direction direction = Sort.Direction.ASC;
        if (sortParts.length > 1) {
            try {
                direction = Sort.Direction.fromString(sortParts[1]);
            } catch (IllegalArgumentException ignored) {
                // fallback to ASC if invalid
                direction = Sort.Direction.ASC;
            }
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<VehicleResponseDto> result = vehicleService.findAllDto(keyword, active, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getVehicleById(@PathVariable UUID id) {
        VehicleResponseDto vehicle = vehicleService.findByIdDto(id);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDto> createVehicle(@RequestBody VehicleRequestDto requestDto) {
        VehicleResponseDto created = vehicleService.createVehicle(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> updateVehicle(
            @PathVariable UUID id,
            @RequestBody VehicleRequestDto requestDto) {
        VehicleResponseDto updated = vehicleService.updateVehicle(id, requestDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID id) {
        if (!vehicleService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/change-active")
    public ResponseEntity<VehicleResponseDto> changeActive(@PathVariable UUID id) {
        VehicleResponseDto updated = vehicleService.changeActive(id);
        return ResponseEntity.ok(updated);
    }
}
