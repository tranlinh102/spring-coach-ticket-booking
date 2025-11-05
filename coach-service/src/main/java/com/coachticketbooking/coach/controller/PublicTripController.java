package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.dto.trip.TripResponseDto;
import com.coachticketbooking.coach.dto.trip.TripSearchDto;
import com.coachticketbooking.coach.service.ITripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/public/trips")
@RequiredArgsConstructor
public class PublicTripController {

    private final ITripService tripService;

    @GetMapping
    public ResponseEntity<List<TripResponseDto>> getAllTrips() {
        return ResponseEntity.ok(tripService.findAllDto());
    }

    @GetMapping("/search")
    public ResponseEntity<List<TripSearchDto>> searchPublicTrips(
            @RequestParam LocalDate departureDate,
            @RequestParam UUID startProvinceId,
            @RequestParam UUID endProvinceId,
            @RequestParam Integer requiredSeats
    ) {
        List<TripSearchDto> trips = tripService.searchTrips(departureDate, startProvinceId, endProvinceId, requiredSeats);
        return ResponseEntity.ok(trips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPublicTripById(@PathVariable UUID id) {
        var trip = tripService.findByIdDto(id);
        return trip != null ? ResponseEntity.ok(trip) : ResponseEntity.notFound().build();
    }
}