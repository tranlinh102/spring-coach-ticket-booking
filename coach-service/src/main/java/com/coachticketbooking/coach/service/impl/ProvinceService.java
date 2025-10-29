package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.model.dto.province.ProvinceRequestDto;
import com.coachticketbooking.coach.model.dto.province.ProvinceResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import com.coachticketbooking.coach.model.mapper.ProvinceMapper;
import com.coachticketbooking.coach.repository.ProvinceRepository;
import com.coachticketbooking.coach.service.IProvinceService;
import com.coachticketbooking.coach.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProvinceService extends BaseService<Province, UUID> implements IProvinceService {

    private final ProvinceMapper provinceMapper;
    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository repository, ProvinceMapper provinceMapper) {
        super(repository);
        this.provinceRepository = repository;
        this.provinceMapper = provinceMapper;
    }

    @Override
    public List<ProvinceResponseDto> findAllDto() {
        return findAll().stream()
                .map(provinceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProvinceResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(provinceMapper::toDto)
                .orElse(null);
    }

    @Override
    public ProvinceResponseDto createProvince(ProvinceRequestDto requestDto) {
        Province province = provinceMapper.toEntity(requestDto);
        Province saved = save(province);
        return provinceMapper.toDto(saved);
    }

    @Override
    public ProvinceResponseDto updateProvince(UUID id, ProvinceRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    provinceMapper.updateEntity(requestDto, existing);
                    Province updated = save(existing);
                    return provinceMapper.toDto(updated);
                })
                .orElse(null);
    }
}
