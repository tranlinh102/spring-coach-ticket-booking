package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.model.dto.province.ProvinceRequestDto;
import com.coachticketbooking.coach.model.dto.province.ProvinceResponseDto;
import com.coachticketbooking.coach.service.IProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final IProvinceService provinceService;

    @GetMapping
    public ResponseEntity<List<ProvinceResponseDto>> getAllProvinces() {
        return ResponseEntity.ok(provinceService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinceResponseDto> getProvinceById(@PathVariable UUID id) {
        ProvinceResponseDto province = provinceService.findByIdDto(id);
        return province != null ? ResponseEntity.ok(province) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProvinceResponseDto> createProvince(@RequestBody ProvinceRequestDto requestDto) {
        ProvinceResponseDto created = provinceService.createProvince(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvinceResponseDto> updateProvince(
            @PathVariable UUID id,
            @RequestBody ProvinceRequestDto requestDto) {
        ProvinceResponseDto updated = provinceService.updateProvince(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable UUID id) {
        if (!provinceService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        provinceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
