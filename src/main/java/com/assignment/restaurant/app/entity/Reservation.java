package com.assignment.restaurant.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "no_of_guests")
    private int noOfGuests;

    @Column(name = "time_slot")
    private String timeSlot;

    @Column(name = "confirmed")
    private boolean confirmed = true;


}
