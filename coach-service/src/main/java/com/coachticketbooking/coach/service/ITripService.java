package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.dto.trip.TripRequestDto;
import com.coachticketbooking.coach.dto.trip.TripResponseDto;
import com.coachticketbooking.coach.dto.trip.TripSearchDto;
import com.coachticketbooking.coach.model.entity.Trip;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ITripService extends IBaseService<Trip, UUID> {
    List<TripResponseDto> findAllDto();
    TripResponseDto findByIdDto(UUID id);
    TripResponseDto createTrip(TripRequestDto requestDto);
    TripResponseDto updateTrip(UUID id, TripRequestDto requestDto);
    List<TripSearchDto> searchTrips(LocalDate departureDate, UUID startProvinceId, UUID endProvinceId, Integer requiredSeats);
}
