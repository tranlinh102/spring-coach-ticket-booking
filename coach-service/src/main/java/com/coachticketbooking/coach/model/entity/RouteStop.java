package com.coachticketbooking.coach.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "route_stops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteStop {

    @EmbeddedId
    private RouteStopId id = new RouteStopId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("routeId")
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stopId")
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @Column(nullable = false)
    private Integer stopOrder; // Thứ tự trạm trong tuyến

    @Column(name = "is_bus_station", nullable = false)
    private boolean isBusStation = false;

    @Column(name = "allow_pickup", nullable = false)
    private boolean allowPickup = true;

    @Column(name = "allow_dropoff", nullable = false)
    private boolean allowDropoff = true;

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

