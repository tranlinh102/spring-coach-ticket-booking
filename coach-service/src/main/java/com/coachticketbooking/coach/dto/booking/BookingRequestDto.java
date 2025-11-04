package com.coachticketbooking.coach.dto.booking;

import com.coachticketbooking.coach.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    private UUID tripId;
    private UUID customerId;
    private String buyerName;
    private String buyerPhone;
    private String buyerEmail;
    private UUID staffId;
    private UUID pickupStopId;
    private UUID dropoffStopId;
    private Integer seatCount;
    private PaymentMethod paymentMethod;
}