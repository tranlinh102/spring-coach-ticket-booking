package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, UUID> {
}

