package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.model.dto.trip.TripSearchDto;
import com.coachticketbooking.coach.model.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
    @Query(value = """
            WITH daily_trips AS (
                SELECT
                    t.id AS trip_id,
                    t.scheduled_departure_time,
                    t.route_id,
                    v.vehicle_type,
                    v.active_seat_count
                FROM trips t
                JOIN vehicles v ON t.vehicle_id = v.id
                WHERE DATE(t.scheduled_departure_time) = :departureDate
            ),
            valid_trip_routes AS (
                SELECT
                    dt.trip_id,
                    dt.scheduled_departure_time,
                    dt.route_id,
                    dt.vehicle_type,
                    dt.active_seat_count,
                    rs_start.stop_order AS start_order,
                    rs_end.stop_order AS end_order,
                    s_start.address AS start_address,
                    s_start.province_id AS start_province_id,
                    s_end.address AS end_address,
                    s_end.province_id AS end_province_id
                FROM daily_trips dt
                JOIN routes r ON r.id = dt.route_id
                JOIN route_stops rs_start ON rs_start.route_id = r.id
                JOIN route_stops rs_end ON rs_end.route_id = r.id
                JOIN stops s_start ON rs_start.stop_id = s_start.id
                JOIN stops s_end ON rs_end.stop_id = s_end.id
                WHERE s_start.province_id = :startProvinceId
                  AND s_end.province_id = :endProvinceId
                  AND rs_start.stop_order < rs_end.stop_order
                  AND rs_start.allow_pickup = 1
                  AND rs_end.allow_dropoff = 1
            ),
            booking_filter AS (
                SELECT
                    vtr.trip_id,
                    SUM(b.seat_count) AS seat_reserved_count
                FROM valid_trip_routes vtr
                JOIN bookings b ON b.trip_id = vtr.trip_id
                JOIN route_stops rs_pickup ON b.pickup_stop_id = rs_pickup.stop_id AND vtr.route_id = rs_pickup.route_id\s
                JOIN route_stops rs_dropoff ON b.dropoff_stop_id = rs_dropoff.stop_id AND vtr.route_id = rs_dropoff.route_id\s
                WHERE
                    (
                        (rs_pickup.stop_order < vtr.start_order AND rs_dropoff.stop_order <= vtr.start_order)
                        OR
                        (rs_pickup.stop_order >= vtr.end_order AND rs_dropoff.stop_order > vtr.end_order)
                    )
                GROUP BY vtr.trip_id
            )
            SELECT
                BIN_TO_UUID(vtr.trip_id) AS trip_id,
                vtr.scheduled_departure_time,
                vtr.start_address,
                vtr.end_address,
                vtr.vehicle_type,
                vtr.active_seat_count,
                (vtr.active_seat_count - COALESCE(bf.seat_reserved_count, 0)) AS available_seats
            FROM valid_trip_routes vtr
            LEFT JOIN booking_filter bf ON bf.trip_id = vtr.trip_id
            WHERE
                (:requiredSeats IS NULL OR (vtr.active_seat_count - COALESCE(bf.seat_reserved_count, 0)) >= :requiredSeats);
        """, nativeQuery = true)
    List<TripSearchDto> searchTrips(
            @Param("departureDate") LocalDate departureDate,
            @Param("startProvinceId") UUID startProvinceId,
            @Param("endProvinceId") UUID endProvinceId,
            @Param("requiredSeats") Integer requiredSeats
    );


}


