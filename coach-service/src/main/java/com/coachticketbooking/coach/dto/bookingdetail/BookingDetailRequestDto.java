package com.coachticketbooking.coach.dto.bookingdetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailRequestDto {
    private UUID bookingId;
    private UUID seatId;
    private BigDecimal price;
    private BigDecimal discountAmount;
    private BigDecimal discountPercent;
}

