package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WardRepository extends JpaRepository<Ward, UUID> {
}

