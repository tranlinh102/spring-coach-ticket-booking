package com.coachticketbooking.coach.init;

import com.coachticketbooking.coach.model.entity.*;
import com.coachticketbooking.coach.model.enums.VehicleType;
import com.coachticketbooking.coach.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProvinceRepository provinceRepository;
    private final WardRepository wardRepository;
    private final StopRepository stopRepository;
    private final VehicleRepository vehicleRepository;
    private final SeatRepository seatRepository;
    private final RouteRepository routeRepository;
    private final RouteStopRepository routeStopRepository;
    private final TripRepository tripRepository;
    private final BookingRepository bookingRepository;
    private final BookingDetailRepository bookingDetailRepository;

    @Override
    public void run(String... args) {
        // 1) Provinces
        List<Province> savedProvinces;
        if (provinceRepository.count() == 0) {
            List<Province> provinces = List.of(
                    new Province("01", "Thành phố Hà Nội"),
                    new Province("04", "Tỉnh Cao Bằng"),
                    new Province("08", "Tỉnh Tuyên Quang"),
                    new Province("11", "Tỉnh Điện Biên"),
                    new Province("12", "Tỉnh Lai Châu"),
                    new Province("14", "Tỉnh Sơn La"),
                    new Province("15", "Tỉnh Lào Cai"),
                    new Province("19", "Tỉnh Thái Nguyên"),
                    new Province("20", "Tỉnh Lạng Sơn"),
                    new Province("22", "Tỉnh Quảng Ninh"),
                    new Province("24", "Tỉnh Bắc Ninh"),
                    new Province("25", "Tỉnh Phú Thọ"),
                    new Province("31", "Thành phố Hải Phòng"),
                    new Province("33", "Tỉnh Hưng Yên"),
                    new Province("37", "Tỉnh Ninh Bình"),
                    new Province("38", "Tỉnh Thanh Hóa"),
                    new Province("40", "Tỉnh Nghệ An"),
                    new Province("42", "Tỉnh Hà Tĩnh"),
                    new Province("44", "Tỉnh Quảng Trị"),
                    new Province("46", "Thành phố Huế"),
                    new Province("48", "Thành phố Đà Nẵng"),
                    new Province("51", "Tỉnh Quảng Ngãi"),
                    new Province("52", "Tỉnh Gia Lai"),
                    new Province("56", "Tỉnh Khánh Hòa"),
                    new Province("66", "Tỉnh Đắk Lắk"),
                    new Province("68", "Tỉnh Lâm Đồng"),
                    new Province("75", "Tỉnh Đồng Nai"),
                    new Province("79", "Thành phố Hồ Chí Minh"),
                    new Province("80", "Tỉnh Tây Ninh"),
                    new Province("82", "Tỉnh Đồng Tháp"),
                    new Province("86", "Tỉnh Vĩnh Long"),
                    new Province("91", "Tỉnh An Giang"),
                    new Province("92", "Thành phố Cần Thơ"),
                    new Province("96", "Tỉnh Cà Mau")
            );

            savedProvinces = provinceRepository.saveAll(provinces);
        } else {
            savedProvinces = provinceRepository.findAll();
        }

        // 2) Wards (sample for HCM)
        List<Ward> savedWards = new ArrayList<>();
        if (wardRepository.count() == 0) {
            Province hcm = savedProvinces.stream().filter(p -> "79".equals(p.getCode())).findFirst().orElse(savedProvinces.getFirst());

            Ward w1 = new Ward();
            w1.setProvince(hcm);
            w1.setCode("79001");
            w1.setName("Quận 1");

            Ward w2 = new Ward();
            w2.setProvince(hcm);
            w2.setCode("79002");
            w2.setName("Quận 3");

            savedWards = wardRepository.saveAll(List.of(w1, w2));
        } else {
            savedWards = wardRepository.findAll();
        }

        // 3) Stops
        List<Stop> savedStops = new ArrayList<>();
        if (stopRepository.count() == 0) {
            Province hcm = savedProvinces.stream().filter(p -> "79".equals(p.getCode())).findFirst().orElse(savedProvinces.getFirst());
            Ward w1 = !savedWards.isEmpty() ? savedWards.getFirst() : null;

            Stop s1 = new Stop();
            s1.setName("Bến xe Miền Đông");
            s1.setAddress("292 Đinh Bộ Lĩnh, Bình Thạnh, TP.HCM");
            s1.setProvince(hcm);
            s1.setWard(w1);
            s1.setBusStation(true);

            Stop s2 = new Stop();
            s2.setName("Bến xe Trung Tâm");
            s2.setAddress("Số 1, Đường Trung Tâm, Quận 1, TP.HCM");
            s2.setProvince(hcm);
            s2.setWard(w1);
            s2.setBusStation(true);

            savedStops = stopRepository.saveAll(List.of(s1, s2));
        } else {
            savedStops = stopRepository.findAll();
        }

        // 4) Vehicle & Seats
        Vehicle savedVehicle;
        if (vehicleRepository.count() == 0) {
            Vehicle v = new Vehicle();
            v.setLicensePlate("51B-12345");
            v.setSeatCapacity(40);
            v.setActiveSeatCount(40);
            v.setType(VehicleType.SEAT);
            savedVehicle = vehicleRepository.save(v);
        } else {
            savedVehicle = vehicleRepository.findAll().getFirst();
        }

        List<Seat> savedSeats = new ArrayList<>();
        if (seatRepository.count() == 0) {
            int capacity = savedVehicle.getSeatCapacity() != null ? savedVehicle.getSeatCapacity() : 10;
            List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= Math.min(capacity, 50); i++) {
                Seat seat = new Seat();
                seat.setVehicle(savedVehicle);
                seat.setSeatCode(String.format("%02d", i));
                seat.setDeckNumber(1);
                seats.add(seat);
            }
            savedSeats = seatRepository.saveAll(seats);
        } else {
            savedSeats = seatRepository.findAll();
        }

        // 5) Route & RouteStops
        Route savedRoute;
        if (routeRepository.count() == 0) {
            Stop start = !savedStops.isEmpty() ? savedStops.get(0) : null;
            Stop end = savedStops.size() > 1 ? savedStops.get(1) : start;

            Route route = new Route();
            route.setCode("HCM-EX-01");
            route.setName("TP.HCM - Tuyến mẫu");
            route.setStartStop(start);
            route.setEndStop(end);
            route.setDistanceKm(120.0);

            savedRoute = routeRepository.save(route);

            List<RouteStop> rss = new ArrayList<>();
            if (start != null) {
                RouteStop rs1 = new RouteStop();
                rs1.setRoute(savedRoute);
                rs1.setStop(start);
                rs1.setStopOrder(1);
                rs1.setAllowPickup(true);
                rs1.setAllowDropoff(true);
                rs1.setActive(true);
                rs1.setId(new RouteStopId(savedRoute.getId(), start.getId()));
                rss.add(rs1);
            }

            if (end != null) {
                RouteStop rs2 = new RouteStop();
                rs2.setRoute(savedRoute);
                rs2.setStop(end);
                rs2.setStopOrder(2);
                rs2.setAllowPickup(true);
                rs2.setAllowDropoff(true);
                rs2.setActive(true);
                rs2.setId(new RouteStopId(savedRoute.getId(), end.getId()));
                rss.add(rs2);
            }

            if (!rss.isEmpty()) {
                routeStopRepository.saveAll(rss);
            }
        } else {
            savedRoute = routeRepository.findAll().getFirst();
        }

        // 6) Trip
        Trip savedTrip;
        if (tripRepository.count() == 0) {
            Trip trip = new Trip();
            trip.setRoute(savedRoute);
            trip.setVehicle(savedVehicle);
            trip.setScheduledDepartureTime(LocalDateTime.now().plusDays(1));
            trip.setScheduledArrivalTime(LocalDateTime.now().plusDays(1).plusHours(3));
            trip.setPrice(new BigDecimal("150000"));
            savedTrip = tripRepository.save(trip);
        } else {
            savedTrip = tripRepository.findAll().getFirst();
        }

        // 7) Booking & BookingDetail
        if (bookingRepository.count() == 0) {
            Booking booking = new Booking();
            booking.setBookingCode("BK" + System.currentTimeMillis());
            booking.setTrip(savedTrip);
            booking.setBuyerName("Người Mua Mẫu");
            booking.setBuyerPhone("0123456789");
            booking.setBuyerEmail("buyer@example.com");
            booking.setStaffId(UUID.randomUUID());
            booking.setPickupStop(!savedStops.isEmpty() ? savedStops.get(0) : null);
            booking.setDropoffStop(savedStops.size() > 1 ? savedStops.get(1) : savedStops.get(0));
            booking.setSeatCount(1);
            booking.setTotalAmount(savedTrip != null && savedTrip.getPrice() != null ? savedTrip.getPrice() : BigDecimal.ZERO);

            Booking savedBooking = bookingRepository.save(booking);

            if (!savedSeats.isEmpty()) {
                Seat seat = savedSeats.getFirst();
                BookingDetail detail = new BookingDetail();
                detail.setBooking(savedBooking);
                detail.setSeat(seat);
                detail.setPrice(savedTrip != null && savedTrip.getPrice() != null ? savedTrip.getPrice() : BigDecimal.ZERO);
                bookingDetailRepository.save(detail);
            }
        }

        System.out.println("Seed data inserted successfully!");
    }
}
