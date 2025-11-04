package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.dto.stop.StopRequestDto;
import com.coachticketbooking.coach.dto.stop.StopResponseDto;
import com.coachticketbooking.coach.service.IStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stops")
@RequiredArgsConstructor
public class StopController {

    private final IStopService stopService;

    @GetMapping
    public ResponseEntity<List<StopResponseDto>> getAllStops() {
        return ResponseEntity.ok(stopService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StopResponseDto> getStopById(@PathVariable UUID id) {
        StopResponseDto stop = stopService.findByIdDto(id);
        return stop != null ? ResponseEntity.ok(stop) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<StopResponseDto> createStop(@RequestBody StopRequestDto requestDto) {
        StopResponseDto created = stopService.createStop(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StopResponseDto> updateStop(
            @PathVariable UUID id,
            @RequestBody StopRequestDto requestDto) {
        StopResponseDto updated = stopService.updateStop(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStop(@PathVariable UUID id) {
        if (!stopService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stopService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
