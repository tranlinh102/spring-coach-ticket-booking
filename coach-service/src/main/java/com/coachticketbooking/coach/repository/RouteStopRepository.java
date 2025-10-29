package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.RouteStop;
import com.coachticketbooking.coach.model.entity.RouteStopId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStopRepository extends JpaRepository<RouteStop, RouteStopId> {
}

