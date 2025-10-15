package com.coachticketbooking.coach.model;

//import jakarta.persistence.Table;
import lombok.*;

//@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Vehicles {
    private String vehicleId;
    private String vehicleName;
    private String vehicleType;
    private int capacity;
}
