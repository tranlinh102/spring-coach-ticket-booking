package com.coachticketbooking.coach.dto.seat;

import com.coachticketbooking.coach.model.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponseDto {
    private UUID id;
    private UUID vehicleId;
    private String seatCode;
    private Integer deckNumber;
    private SeatStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

