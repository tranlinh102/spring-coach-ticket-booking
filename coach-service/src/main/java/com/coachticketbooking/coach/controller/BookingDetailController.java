package com.coachticketbooking.coach.controller;

import com.coachticketbooking.coach.dto.bookingdetail.BookingDetailRequestDto;
import com.coachticketbooking.coach.dto.bookingdetail.BookingDetailResponseDto;
import com.coachticketbooking.coach.service.IBookingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking-details")
@RequiredArgsConstructor
public class BookingDetailController {

    private final IBookingDetailService bookingDetailService;

    @GetMapping
    public ResponseEntity<List<BookingDetailResponseDto>> getAllBookingDetails() {
        return ResponseEntity.ok(bookingDetailService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDetailResponseDto> getBookingDetailById(@PathVariable UUID id) {
        BookingDetailResponseDto bookingDetail = bookingDetailService.findByIdDto(id);
        return bookingDetail != null ? ResponseEntity.ok(bookingDetail) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookingDetailResponseDto> createBookingDetail(@RequestBody BookingDetailRequestDto requestDto) {
        BookingDetailResponseDto created = bookingDetailService.createBookingDetail(requestDto);
        return created != null ? ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDetailResponseDto> updateBookingDetail(
            @PathVariable UUID id,
            @RequestBody BookingDetailRequestDto requestDto) {
        BookingDetailResponseDto updated = bookingDetailService.updateBookingDetail(id, requestDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingDetail(@PathVariable UUID id) {
        if (!bookingDetailService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookingDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
