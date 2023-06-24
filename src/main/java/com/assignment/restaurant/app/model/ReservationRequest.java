package com.assignment.restaurant.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private String name;
    private String location;
    private String phone;
    private String email;
    private LocalDate reservationDate;
    private int noOfGuests;
    private String timeSlot;
}
