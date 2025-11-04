package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.dto.routestop.RouteStopRequestDto;
import com.coachticketbooking.coach.dto.routestop.RouteStopResponseDto;
import com.coachticketbooking.coach.service.IRouteStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/route-stops")
@RequiredArgsConstructor
public class RouteStopController {

    private final IRouteStopService routeStopService;

    @GetMapping
    public ResponseEntity<List<RouteStopResponseDto>> getAllRouteStops() {
        return ResponseEntity.ok(routeStopService.findAllDto());
    }

    @GetMapping("/{routeId}/{stopId}")
    public ResponseEntity<RouteStopResponseDto> getRouteStopById(
            @PathVariable UUID routeId,
            @PathVariable UUID stopId) {
        RouteStopResponseDto routeStop = routeStopService.findByIdDto(routeId, stopId);
        return routeStop != null ? ResponseEntity.ok(routeStop) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RouteStopResponseDto> createRouteStop(@RequestBody RouteStopRequestDto requestDto) {
        RouteStopResponseDto created = routeStopService.createRouteStop(requestDto);
        return created != null ? ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.badRequest().build();
    }

    @PutMapping("/{routeId}/{stopId}")
    public ResponseEntity<RouteStopResponseDto> updateRouteStop(
            @PathVariable UUID routeId,
            @PathVariable UUID stopId,
            @RequestBody RouteStopRequestDto requestDto) {
        RouteStopResponseDto updated = routeStopService.updateRouteStop(routeId, stopId, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{routeId}/{stopId}")
    public ResponseEntity<Void> deleteRouteStop(
            @PathVariable UUID routeId,
            @PathVariable UUID stopId) {
        if (!routeStopService.existsById(new com.coachticketbooking.coach.model.entity.RouteStopId(routeId, stopId))) {
            return ResponseEntity.notFound().build();
        }
        routeStopService.deleteById(new com.coachticketbooking.coach.model.entity.RouteStopId(routeId, stopId));
        return ResponseEntity.noContent().build();
    }
}
