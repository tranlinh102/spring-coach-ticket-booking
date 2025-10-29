package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.model.dto.bookingdetail.BookingDetailRequestDto;
import com.coachticketbooking.coach.model.dto.bookingdetail.BookingDetailResponseDto;
import com.coachticketbooking.coach.model.entity.Booking;
import com.coachticketbooking.coach.model.entity.BookingDetail;
import com.coachticketbooking.coach.model.entity.Seat;
import com.coachticketbooking.coach.model.mapper.BookingDetailMapper;
import com.coachticketbooking.coach.repository.BookingDetailRepository;
import com.coachticketbooking.coach.service.IBookingDetailService;
import com.coachticketbooking.coach.service.IBookingService;
import com.coachticketbooking.coach.service.ISeatService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingDetailService extends BaseService<BookingDetail, UUID> implements IBookingDetailService {

    private final BookingDetailMapper bookingDetailMapper;
    private final IBookingService bookingService;
    private final ISeatService seatService;
    private final BookingDetailRepository bookingDetailRepository;

    public BookingDetailService(BookingDetailRepository repository, BookingDetailMapper bookingDetailMapper,
                               IBookingService bookingService, ISeatService seatService) {
        super(repository);
        this.bookingDetailRepository = repository;
        this.bookingDetailMapper = bookingDetailMapper;
        this.bookingService = bookingService;
        this.seatService = seatService;
    }

    @Override
    public List<BookingDetailResponseDto> findAllDto() {
        return findAll().stream()
                .map(bookingDetailMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDetailResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(bookingDetailMapper::toDto)
                .orElse(null);
    }

    @Override
    public BookingDetailResponseDto createBookingDetail(BookingDetailRequestDto requestDto) {
        Booking booking = requestDto.getBookingId() != null ?
                bookingService.findById(requestDto.getBookingId()).orElse(null) : null;
        Seat seat = requestDto.getSeatId() != null ?
                seatService.findById(requestDto.getSeatId()).orElse(null) : null;

        BookingDetail bookingDetail = bookingDetailMapper.toEntity(requestDto, booking, seat);
        BookingDetail saved = save(bookingDetail);
        return bookingDetailMapper.toDto(saved);
    }

    @Override
    public BookingDetailResponseDto updateBookingDetail(UUID id, BookingDetailRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Booking booking = requestDto.getBookingId() != null ?
                            bookingService.findById(requestDto.getBookingId()).orElse(null) : null;
                    Seat seat = requestDto.getSeatId() != null ?
                            seatService.findById(requestDto.getSeatId()).orElse(null) : null;

                    bookingDetailMapper.updateEntity(requestDto, existing, booking, seat);
                    BookingDetail updated = save(existing);
                    return bookingDetailMapper.toDto(updated);
                })
                .orElse(null);
    }
}
