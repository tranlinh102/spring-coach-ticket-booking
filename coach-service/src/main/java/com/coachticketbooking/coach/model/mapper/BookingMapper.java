package com.coachticketbooking.coach.model.mapper;

import com.coachticketbooking.coach.model.dto.booking.BookingRequestDto;
import com.coachticketbooking.coach.model.dto.booking.BookingResponseDto;
import com.coachticketbooking.coach.model.entity.Booking;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.model.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResponseDto toDto(Booking entity) {
        if (entity == null) return null;

        BookingResponseDto dto = new BookingResponseDto();
        dto.setId(entity.getId());
        dto.setBookingCode(entity.getBookingCode());
        dto.setTripId(entity.getTrip() != null ? entity.getTrip().getId() : null);
        dto.setCustomerId(entity.getCustomerId());
        dto.setBuyerName(entity.getBuyerName());
        dto.setBuyerPhone(entity.getBuyerPhone());
        dto.setBuyerEmail(entity.getBuyerEmail());
        dto.setStaffId(entity.getStaffId());
        dto.setPickupStopId(entity.getPickupStop() != null ? entity.getPickupStop().getId() : null);
        dto.setDropoffStopId(entity.getDropoffStop() != null ? entity.getDropoffStop().getId() : null);
        dto.setSeatCount(entity.getSeatCount());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setStatus(entity.getStatus());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPaymentStatus(entity.getPaymentStatus());
        dto.setCancelReason(entity.getCancelReason());
        dto.setCanceledAt(entity.getCanceledAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Booking toEntity(BookingRequestDto dto, Trip trip, Stop pickupStop, Stop dropoffStop) {
        if (dto == null) return null;

        Booking entity = new Booking();
        entity.setTrip(trip);
        entity.setCustomerId(dto.getCustomerId());
        entity.setBuyerName(dto.getBuyerName());
        entity.setBuyerPhone(dto.getBuyerPhone());
        entity.setBuyerEmail(dto.getBuyerEmail());
        entity.setStaffId(dto.getStaffId());
        entity.setPickupStop(pickupStop);
        entity.setDropoffStop(dropoffStop);
        entity.setSeatCount(dto.getSeatCount());
        entity.setPaymentMethod(dto.getPaymentMethod());
        return entity;
    }

    public void updateEntity(BookingRequestDto dto, Booking entity, Trip trip, Stop pickupStop, Stop dropoffStop) {
        if (dto == null || entity == null) return;

        if (trip != null) {
            entity.setTrip(trip);
        }
        entity.setCustomerId(dto.getCustomerId());
        entity.setBuyerName(dto.getBuyerName());
        entity.setBuyerPhone(dto.getBuyerPhone());
        entity.setBuyerEmail(dto.getBuyerEmail());
        entity.setStaffId(dto.getStaffId());
        if (pickupStop != null) {
            entity.setPickupStop(pickupStop);
        }
        if (dropoffStop != null) {
            entity.setDropoffStop(dropoffStop);
        }
        entity.setSeatCount(dto.getSeatCount());
        entity.setPaymentMethod(dto.getPaymentMethod());
    }
}

