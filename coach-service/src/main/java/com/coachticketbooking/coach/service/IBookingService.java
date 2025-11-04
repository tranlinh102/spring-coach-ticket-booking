package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.dto.booking.BookingRequestDto;
import com.coachticketbooking.coach.dto.booking.BookingResponseDto;
import com.coachticketbooking.coach.model.entity.Booking;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IBookingService extends IBaseService<Booking, UUID> {
    List<BookingResponseDto> findAllDto();
    BookingResponseDto findByIdDto(UUID id);
    BookingResponseDto createBooking(BookingRequestDto requestDto);
    BookingResponseDto updateBooking(UUID id, BookingRequestDto requestDto);
}