package com.coachticketbooking.coach.service.impl;

import com.coachticketbooking.coach.dto.booking.BookingRequestDto;
import com.coachticketbooking.coach.dto.booking.BookingResponseDto;
import com.coachticketbooking.coach.model.entity.Booking;
import com.coachticketbooking.coach.model.entity.Stop;
import com.coachticketbooking.coach.model.entity.Trip;
import com.coachticketbooking.coach.mapper.BookingMapper;
import com.coachticketbooking.coach.repository.BookingRepository;
import com.coachticketbooking.coach.service.IBookingService;
import com.coachticketbooking.coach.service.IStopService;
import com.coachticketbooking.coach.service.ITripService;
import com.coachticketbooking.coach.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService extends BaseService<Booking, UUID> implements IBookingService {

    private final BookingMapper bookingMapper;
    private final ITripService tripService;
    private final IStopService stopService;
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository repository, BookingMapper bookingMapper,
                         ITripService tripService, IStopService stopService) {
        super(repository);
        this.bookingRepository = repository;
        this.bookingMapper = bookingMapper;
        this.tripService = tripService;
        this.stopService = stopService;
    }

    @Override
    public List<BookingResponseDto> findAllDto() {
        return findAll().stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDto findByIdDto(UUID id) {
        return findById(id)
                .map(bookingMapper::toDto)
                .orElse(null);
    }

    @Override
    public BookingResponseDto createBooking(BookingRequestDto requestDto) {
        Trip trip = requestDto.getTripId() != null ?
                tripService.findById(requestDto.getTripId()).orElse(null) : null;
        Stop pickupStop = requestDto.getPickupStopId() != null ?
                stopService.findById(requestDto.getPickupStopId()).orElse(null) : null;
        Stop dropoffStop = requestDto.getDropoffStopId() != null ?
                stopService.findById(requestDto.getDropoffStopId()).orElse(null) : null;

        Booking booking = bookingMapper.toEntity(requestDto, trip, pickupStop, dropoffStop);
        Booking saved = save(booking);
        return bookingMapper.toDto(saved);
    }

    @Override
    public BookingResponseDto updateBooking(UUID id, BookingRequestDto requestDto) {
        return findById(id)
                .map(existing -> {
                    Trip trip = requestDto.getTripId() != null ?
                            tripService.findById(requestDto.getTripId()).orElse(null) : null;
                    Stop pickupStop = requestDto.getPickupStopId() != null ?
                            stopService.findById(requestDto.getPickupStopId()).orElse(null) : null;
                    Stop dropoffStop = requestDto.getDropoffStopId() != null ?
                            stopService.findById(requestDto.getDropoffStopId()).orElse(null) : null;

                    bookingMapper.updateEntity(requestDto, existing, trip, pickupStop, dropoffStop);
                    Booking updated = save(existing);
                    return bookingMapper.toDto(updated);
                })
                .orElse(null);
    }
}
