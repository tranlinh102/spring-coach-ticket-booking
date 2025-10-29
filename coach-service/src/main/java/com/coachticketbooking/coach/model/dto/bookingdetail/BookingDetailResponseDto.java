package com.coachticketbooking.coach.model.dto.bookingdetail;

import com.coachticketbooking.coach.model.enums.BookingDetailStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailResponseDto {
    private UUID id;
    private UUID bookingId;
    private UUID seatId;
    private BigDecimal price;
    private BigDecimal discountAmount;
    private BigDecimal discountPercent;
    private BookingDetailStatus status;
    private LocalDateTime createdAt;
}

