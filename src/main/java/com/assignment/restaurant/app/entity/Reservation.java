package com.assignment.restaurant.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.IdGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "RESERVATION_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Reservation")
public class Reservation {
    @Id
    private String id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "location")
    @JsonProperty("location")
    private String location;

    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "reservation_date")
    @JsonProperty("reservationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;

    @Column(name = "no_of_guests")
    @JsonProperty("noOfGuests")
    private int noOfGuests;

    @Column(name = "time_slot")
    @JsonProperty("timeSlot")
    private String timeSlot;

    @Column(name = "confirmed")
    private boolean confirmed = true;

}
