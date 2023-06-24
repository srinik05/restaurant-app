package com.assignment.restaurant.app.controller;

import com.assignment.restaurant.app.model.ReservationRequest;
import com.assignment.restaurant.app.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/bookings")
@CrossOrigin
public class UserController {

    private final ReservationService bookingService;

    public UserController(ReservationService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> reserveTable(@RequestBody ReservationRequest bookingRequest) {
        bookingService.saveReservation(bookingRequest);
        return ResponseEntity.ok("Reservation created successfully");
    }


}
