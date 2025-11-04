package com.coachticketbooking.coach.repository;

import com.coachticketbooking.coach.dto.trip.TripSearchDto;
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
                    t.scheduled_arrival_time,
                    t.route_id,
                    t.vehicle_id,
                    t.price,
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
                    dt.scheduled_arrival_time,
                    dt.route_id,
                    dt.vehicle_id,
                    dt.price,
                    dt.vehicle_type,
                    dt.active_seat_count,
                    s_start.address AS start_stop_address,
                    s_start.name AS start_stop_name,
                    s_end.address AS end_stop_address,
                    s_end.name AS end_stop_name,
                    rs_pickup.stop_order AS pickup_order,
                    rs_dropoff.stop_order AS dropoff_order
                FROM daily_trips dt
                JOIN routes r ON r.id = dt.route_id
                JOIN stops s_start ON r.start_stop_id = s_start.id
                JOIN stops s_end ON r.end_stop_id = s_end.id
                JOIN route_stops rs_pickup ON rs_pickup.route_id = r.id
                JOIN route_stops rs_dropoff ON rs_dropoff.route_id = r.id
                JOIN stops s_pickup ON rs_pickup.stop_id = s_pickup.id
                JOIN stops s_dropoff ON rs_dropoff.stop_id = s_dropoff.id
                WHERE s_pickup.province_id = :startProvinceId
                  AND s_dropoff.province_id = :endProvinceId
                  AND rs_pickup.stop_order < rs_dropoff.stop_order
                  AND rs_pickup.allow_pickup = 1
                  AND rs_dropoff.allow_dropoff = 1
            ),
            booking_filter AS (
                SELECT
                    vtr.trip_id,
                    SUM(b.seat_count) AS seat_reserved_count
                FROM valid_trip_routes vtr
                JOIN bookings b ON b.trip_id = vtr.trip_id
                JOIN route_stops rs_pickup ON b.pickup_stop_id = rs_pickup.stop_id AND vtr.route_id = rs_pickup.route_id
                JOIN route_stops rs_dropoff ON b.dropoff_stop_id = rs_dropoff.stop_id AND vtr.route_id = rs_dropoff.route_id
                WHERE
                    (
                        (rs_pickup.stop_order < vtr.pickup_order AND rs_dropoff.stop_order <= vtr.pickup_order)
                        OR
                        (rs_pickup.stop_order >= vtr.dropoff_order AND rs_dropoff.stop_order > vtr.dropoff_order)
                    )
                GROUP BY vtr.trip_id
            )
            SELECT
                BIN_TO_UUID(vtr.trip_id) AS trip_id,
                vtr.scheduled_departure_time,
                vtr.scheduled_arrival_time,
                BIN_TO_UUID(vtr.vehicle_id) AS vehicle_id,
                vtr.price,
                vtr.start_stop_address,
                vtr.start_stop_name,
                vtr.end_stop_address,
                vtr.end_stop_name,
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


