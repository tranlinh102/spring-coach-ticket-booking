package com.coachticketbooking.coach.model.entity;

import com.coachticketbooking.coach.model.enums.TripStatus;
import com.coachticketbooking.common.id.GeneratedUuidV7;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    @GeneratedUuidV7
    private UUID id;

    // Tuyến đường của chuyến
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    // Xe thực hiện chuyến
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    // Tài xế chính (tùy chọn)
    @JoinColumn(name = "driver_id")
    private UUID driver;

    // Thời gian dự kiến (khi lên lịch)
    @Column(name = "scheduled_departure_time", nullable = false)
    private LocalDateTime scheduledDepartureTime;

    @Column(name = "scheduled_arrival_time")
    private LocalDateTime scheduledArrivalTime;

    // Thời gian thực tế
    @Column(name = "actual_departure_time")
    private LocalDateTime actualDepartureTime;

    @Column(name = "actual_arrival_time")
    private LocalDateTime actualArrivalTime;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TripStatus status = TripStatus.SCHEDULED;

    @Column(length = 255)
    private String note;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

