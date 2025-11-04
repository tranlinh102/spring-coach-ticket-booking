package com.coachticketbooking.coach.dto.seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequestDto {
    private UUID vehicleId;
    private String seatCode;
    private Integer deckNumber;
}

