package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.model.dto.route.RouteRequestDto;
import com.coachticketbooking.coach.model.dto.route.RouteResponseDto;
import com.coachticketbooking.coach.service.IRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {

    private final IRouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteResponseDto>> getAllRoutes() {
        return ResponseEntity.ok(routeService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteResponseDto> getRouteById(@PathVariable UUID id) {
        RouteResponseDto route = routeService.findByIdDto(id);
        return route != null ? ResponseEntity.ok(route) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RouteResponseDto> createRoute(@RequestBody RouteRequestDto requestDto) {
        RouteResponseDto created = routeService.createRoute(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteResponseDto> updateRoute(
            @PathVariable UUID id,
            @RequestBody RouteRequestDto requestDto) {
        RouteResponseDto updated = routeService.updateRoute(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable UUID id) {
        if (!routeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
