package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.model.dto.ward.WardRequestDto;
import com.coachticketbooking.coach.model.dto.ward.WardResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import com.coachticketbooking.coach.model.entity.Ward;
import com.coachticketbooking.coach.model.mapper.WardMapper;
import com.coachticketbooking.coach.repository.WardRepository;
import com.coachticketbooking.coach.service.IProvinceService;
import com.coachticketbooking.coach.service.IWardService;
import com.coachticketbooking.coach.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WardService extends BaseService<Ward, UUID> implements IWardService {

    private final WardMapper wardMapper;
    private final IProvinceService provinceService;
    private final WardRepository wardRepository;

    public WardService(WardRepository repository, WardMapper wardMapper, IProvinceService provinceService) {
        super(repository);
        this.wardRepository = repository;
        this.wardMapper = wardMapper;
        this.provinceService = provinceService;
    }

    @Override
    public List<WardResponseDto> findAllDto() {
        return findAll().stream()
                .map(wardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WardResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(wardMapper::toDto)
                .orElse(null);
    }

    @Override
    public WardResponseDto createWard(WardRequestDto requestDto) {
        Province province = provinceService.findById(requestDto.getProvinceId()).orElse(null);
        if (province == null) {
            return null;
        }

        Ward ward = wardMapper.toEntity(requestDto, province);
        Ward saved = save(ward);
        return wardMapper.toDto(saved);
    }

    @Override
    public WardResponseDto updateWard(UUID id, WardRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Province province = null;
                    if (requestDto.getProvinceId() != null) {
                        province = provinceService.findById(requestDto.getProvinceId()).orElse(null);
                    }
                    wardMapper.updateEntity(requestDto, existing, province);
                    Ward updated = save(existing);
                    return wardMapper.toDto(updated);
                })
                .orElse(null);
    }
}
