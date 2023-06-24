package com.assignment.restaurant.app.controller;

import com.assignment.restaurant.app.model.ReservationRequest;
import com.assignment.restaurant.app.model.ReservationResponse;
import com.assignment.restaurant.app.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final ReservationService bookingService;

    public UserController(ReservationService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> reserveTable(@RequestBody ReservationRequest bookingRequest) {
        bookingService.saveReservation(bookingRequest);
        ReservationResponse response = new ReservationResponse("Reservation created successfully");

        return ResponseEntity.ok(response);
    }


}
