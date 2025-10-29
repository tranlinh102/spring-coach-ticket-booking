package com.coachticketbooking.coach.model.entity;

import com.coachticketbooking.common.id.GeneratedUuidV7;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedUuidV7
    private UUID id;

    // Mã tuyến (ví dụ: HCM-HN-01)
    @Column(nullable = false, unique = true, length = 50)
    private String code;

    // Tên tuyến (ví dụ: "TP.HCM - Hà Nội")
    @Column(nullable = false, length = 255)
    private String name;

    // Trạm bắt đầu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_stop_id", nullable = false)
    private Stop startStop;

    // Trạm kết thúc
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_stop_id", nullable = false)
    private Stop endStop;

    // Tổng khoảng cách (km)
    @Column(name = "distance_km")
    private Double distanceKm;

    // Thời gian dự kiến (phút)
    @Column(name = "estimated_duration_minutes")
    private Integer estimatedDurationMinutes;

    // Liên kết với bảng trung gian route_stops
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteStop> routeStops = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean active = true;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

