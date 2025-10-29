package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
}

