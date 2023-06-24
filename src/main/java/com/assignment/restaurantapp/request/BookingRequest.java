package com.assignment.restaurantapp.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {
    private String customerName;
    private String contactNumber;
    private LocalDateTime bookingDateTime;
    private int numberOfGuests;
}
