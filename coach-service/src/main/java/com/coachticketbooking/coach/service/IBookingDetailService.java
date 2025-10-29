package com.coachticketbooking.coach.service;

import com.coachticketbooking.coach.model.dto.bookingdetail.BookingDetailRequestDto;
import com.coachticketbooking.coach.model.dto.bookingdetail.BookingDetailResponseDto;
import com.coachticketbooking.coach.model.entity.BookingDetail;
import com.coachticketbooking.coach.service.base.IBaseService;

import java.util.List;
import java.util.UUID;

public interface IBookingDetailService extends IBaseService<BookingDetail, UUID> {
    List<BookingDetailResponseDto> findAllDto();
    BookingDetailResponseDto findByIdDto(UUID id);
    BookingDetailResponseDto createBookingDetail(BookingDetailRequestDto requestDto);
    BookingDetailResponseDto updateBookingDetail(UUID id, BookingDetailRequestDto requestDto);
}
