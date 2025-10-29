package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}