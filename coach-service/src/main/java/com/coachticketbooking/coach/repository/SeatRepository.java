package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
}

