package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.dto.ward.WardRequestDto;
import com.coachticketbooking.coach.dto.ward.WardResponseDto;
import com.coachticketbooking.coach.model.entity.Ward;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IWardService extends IBaseService<Ward, UUID> {
    List<WardResponseDto> findAllDto();
    WardResponseDto findByIdDto(UUID id);
    WardResponseDto createWard(WardRequestDto requestDto);
    WardResponseDto updateWard(UUID id, WardRequestDto requestDto);
}
