package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvinceRepository extends JpaRepository<Province, UUID> {
}
