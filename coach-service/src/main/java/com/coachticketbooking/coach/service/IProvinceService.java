package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.model.dto.province.ProvinceRequestDto;
import com.coachticketbooking.coach.model.dto.province.ProvinceResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IProvinceService extends IBaseService<Province, UUID> {
    List<ProvinceResponseDto> findAllDto();
    ProvinceResponseDto findByIdDto(UUID id);
    ProvinceResponseDto createProvince(ProvinceRequestDto requestDto);
    ProvinceResponseDto updateProvince(UUID id, ProvinceRequestDto requestDto);
}