package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.stop.StopRequestDto;
import com.coachticketbooking.coach.dto.stop.StopResponseDto;
import com.coachticketbooking.coach.model.entity.Province;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.model.entity.Ward;
import com.coachticketbooking.coach.mapper.StopMapper;
import com.coachticketbooking.coach.repository.StopRepository;
import com.coachticketbooking.coach.service.IProvinceService;
import com.coachticketbooking.coach.service.IStopService;
import com.coachticketbooking.coach.service.IWardService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StopService extends BaseService<Stop, UUID> implements IStopService {

    private final StopMapper stopMapper;
    private final IProvinceService provinceService;
    private final IWardService wardService;
    private final StopRepository stopRepository;

    public StopService(StopRepository repository, StopMapper stopMapper,
                      IProvinceService provinceService, IWardService wardService) {
        super(repository);
        this.stopRepository = repository;
        this.stopMapper = stopMapper;
        this.provinceService = provinceService;
        this.wardService = wardService;
    }

    @Override
    public List<StopResponseDto> findAllDto() {
        return findAll().stream()
                .map(stopMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StopResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(stopMapper::toDto)
                .orElse(null);
    }

    @Override
    public StopResponseDto createStop(StopRequestDto requestDto) {
        Province province = requestDto.getProvinceId() != null ?
                provinceService.findById(requestDto.getProvinceId()).orElse(null) : null;
        Ward ward = requestDto.getWardId() != null ?
                wardService.findById(requestDto.getWardId()).orElse(null) : null;

        Stop stop = stopMapper.toEntity(requestDto, province, ward);
        Stop saved = save(stop);
        return stopMapper.toDto(saved);
    }

    @Override
    public StopResponseDto updateStop(UUID id, StopRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Province province = requestDto.getProvinceId() != null ?
                            provinceService.findById(requestDto.getProvinceId()).orElse(null) : null;
                    Ward ward = requestDto.getWardId() != null ?
                            wardService.findById(requestDto.getWardId()).orElse(null) : null;

                    stopMapper.updateEntity(requestDto, existing, province, ward);
                    Stop updated = save(existing);
                    return stopMapper.toDto(updated);
                })
                .orElse(null);
    }
}
