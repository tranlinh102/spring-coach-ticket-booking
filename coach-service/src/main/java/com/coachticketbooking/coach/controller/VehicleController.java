package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.model.dto.vehicle.VehicleRequestDto;
import com.coachticketbooking.coach.model.dto.vehicle.VehicleResponseDto;
import com.coachticketbooking.coach.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAllDto());
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
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID id) {
        if (!vehicleService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
