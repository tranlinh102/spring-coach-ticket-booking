package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.dto.ward.WardRequestDto;
import com.coachticketbooking.coach.dto.ward.WardResponseDto;
import com.coachticketbooking.coach.service.IWardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wards")
@RequiredArgsConstructor
public class WardController {

    private final IWardService wardService;

    @GetMapping
    public ResponseEntity<List<WardResponseDto>> getAllWards() {
        return ResponseEntity.ok(wardService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WardResponseDto> getWardById(@PathVariable UUID id) {
        WardResponseDto ward = wardService.findByIdDto(id);
        return ward != null ? ResponseEntity.ok(ward) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<WardResponseDto> createWard(@RequestBody WardRequestDto requestDto) {
        WardResponseDto created = wardService.createWard(requestDto);
        return created != null ? ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WardResponseDto> updateWard(
            @PathVariable UUID id,
            @RequestBody WardRequestDto requestDto) {
        WardResponseDto updated = wardService.updateWard(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWard(@PathVariable UUID id) {
        if (!wardService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        wardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
