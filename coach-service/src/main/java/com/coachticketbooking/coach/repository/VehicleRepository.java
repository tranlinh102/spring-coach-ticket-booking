package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    Optional<Vehicle> findByLicensePlate(String licensePlate);
    Page<Vehicle> findByLicensePlateContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Vehicle> findByLicensePlateContainingIgnoreCaseAndActive(String keyword, Boolean active, Pageable pageable);
    Page<Vehicle> findByActive(Boolean active, Pageable pageable);
}
