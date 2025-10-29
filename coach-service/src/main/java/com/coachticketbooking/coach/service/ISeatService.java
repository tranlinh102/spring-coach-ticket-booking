package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.model.dto.seat.SeatRequestDto;
import com.coachticketbooking.coach.model.dto.seat.SeatResponseDto;
import com.coachticketbooking.coach.model.entity.Seat;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface ISeatService extends IBaseService<Seat, UUID> {
    List<SeatResponseDto> findAllDto();
    SeatResponseDto findByIdDto(UUID id);
    SeatResponseDto createSeat(SeatRequestDto requestDto);
    SeatResponseDto updateSeat(UUID id, SeatRequestDto requestDto);
}
