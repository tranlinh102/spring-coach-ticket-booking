package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.model.dto.seat.SeatRequestDto;
import com.coachticketbooking.coach.model.dto.seat.SeatResponseDto;
import com.coachticketbooking.coach.service.ISeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {

    private final ISeatService seatService;

    @GetMapping
    public ResponseEntity<List<SeatResponseDto>> getAllSeats() {
        return ResponseEntity.ok(seatService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatResponseDto> getSeatById(@PathVariable UUID id) {
        SeatResponseDto seat = seatService.findByIdDto(id);
        return seat != null ? ResponseEntity.ok(seat) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SeatResponseDto> createSeat(@RequestBody SeatRequestDto requestDto) {
        SeatResponseDto created = seatService.createSeat(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatResponseDto> updateSeat(
            @PathVariable UUID id,
            @RequestBody SeatRequestDto requestDto) {
        SeatResponseDto updated = seatService.updateSeat(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable UUID id) {
        if (!seatService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        seatService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
