package com.coachticketbooking.coach.model.mapper;

import com.coachticketbooking.coach.model.dto.bookingdetail.BookingDetailRequestDto;
import com.coachticketbooking.coach.model.dto.bookingdetail.BookingDetailResponseDto;
import com.coachticketbooking.coach.model.entity.Booking;
import com.coachticketbooking.coach.model.entity.BookingDetail;
import com.coachticketbooking.coach.model.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class BookingDetailMapper {

    public BookingDetailResponseDto toDto(BookingDetail entity) {
        if (entity == null) return null;

        BookingDetailResponseDto dto = new BookingDetailResponseDto();
        dto.setId(entity.getId());
        dto.setBookingId(entity.getBooking() != null ? entity.getBooking().getId() : null);
        dto.setSeatId(entity.getSeat() != null ? entity.getSeat().getId() : null);
        dto.setPrice(entity.getPrice());
        dto.setDiscountAmount(entity.getDiscountAmount());
        dto.setDiscountPercent(entity.getDiscountPercent());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public BookingDetail toEntity(BookingDetailRequestDto dto, Booking booking, Seat seat) {
        if (dto == null) return null;

        BookingDetail entity = new BookingDetail();
        entity.setBooking(booking);
        entity.setSeat(seat);
        entity.setPrice(dto.getPrice());
        entity.setDiscountAmount(dto.getDiscountAmount());
        entity.setDiscountPercent(dto.getDiscountPercent());
        return entity;
    }

    public void updateEntity(BookingDetailRequestDto dto, BookingDetail entity, Booking booking, Seat seat) {
        if (dto == null || entity == null) return;

        if (booking != null) {
            entity.setBooking(booking);
        }
        if (seat != null) {
            entity.setSeat(seat);
        }
        entity.setPrice(dto.getPrice());
        entity.setDiscountAmount(dto.getDiscountAmount());
        entity.setDiscountPercent(dto.getDiscountPercent());
    }
}

