package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.model.dto.stop.StopRequestDto;
import com.coachticketbooking.coach.model.dto.stop.StopResponseDto;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IStopService extends IBaseService<Stop, UUID> {
    List<StopResponseDto> findAllDto();
    StopResponseDto findByIdDto(UUID id);
    StopResponseDto createStop(StopRequestDto requestDto);
    StopResponseDto updateStop(UUID id, StopRequestDto requestDto);
}
