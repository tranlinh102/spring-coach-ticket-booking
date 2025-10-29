package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.model.dto.trip.TripRequestDto;
import com.coachticketbooking.coach.model.dto.trip.TripResponseDto;
import com.coachticketbooking.coach.model.dto.trip.TripSearchDto;
import com.coachticketbooking.coach.service.ITripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final ITripService tripService;

    @GetMapping
    public ResponseEntity<List<TripResponseDto>> getAllTrips() {
        return ResponseEntity.ok(tripService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripResponseDto> getTripById(@PathVariable UUID id) {
        TripResponseDto trip = tripService.findByIdDto(id);
        return trip != null ? ResponseEntity.ok(trip) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TripResponseDto> createTrip(@RequestBody TripRequestDto requestDto) {
        TripResponseDto created = tripService.createTrip(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripResponseDto> updateTrip(
            @PathVariable UUID id,
            @RequestBody TripRequestDto requestDto) {
        TripResponseDto updated = tripService.updateTrip(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable UUID id) {
        if (!tripService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tripService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<TripSearchDto>> searchTrips(
            @RequestParam LocalDate departureDate,
            @RequestParam UUID startProvinceId,
            @RequestParam UUID endProvinceId,
            @RequestParam Integer requiredSeats
    ) {
        List<TripSearchDto> trips = tripService.searchTrips(departureDate, startProvinceId, endProvinceId, requiredSeats);
        return ResponseEntity.ok(trips);
    }
}
