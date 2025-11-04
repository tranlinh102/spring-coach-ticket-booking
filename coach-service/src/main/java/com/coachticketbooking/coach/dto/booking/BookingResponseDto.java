package com.coachticketbooking.coach.dto.booking;

import com.coachticketbooking.coach.model.enums.BookingStatus;
import com.coachticketbooking.coach.model.enums.PaymentMethod;
import com.coachticketbooking.coach.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {
    private UUID id;
    private String bookingCode;
    private UUID tripId;
    private UUID customerId;
    private String buyerName;
    private String buyerPhone;
    private String buyerEmail;
    private UUID staffId;
    private UUID pickupStopId;
    private UUID dropoffStopId;
    private Integer seatCount;
    private BigDecimal totalAmount;
    private BookingStatus status;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private String cancelReason;
    private LocalDateTime canceledAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

