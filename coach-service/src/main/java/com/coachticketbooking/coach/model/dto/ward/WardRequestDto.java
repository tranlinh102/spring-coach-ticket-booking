package com.coachticketbooking.coach.model.dto.ward;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WardRequestDto {
    private UUID provinceId;
    private String code;
    private String name;
}

