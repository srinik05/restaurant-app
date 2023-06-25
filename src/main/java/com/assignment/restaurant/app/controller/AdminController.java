package com.assignment.restaurant.app.controller;


import com.assignment.restaurant.app.entity.Reservation;
import com.assignment.restaurant.app.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private final ReservationService reservationService;

    public AdminController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getBooking(@PathVariable String id) {
        Reservation booking = reservationService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllBookings() {
        List<Reservation> bookings = reservationService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateBooking(@PathVariable String id, @RequestBody Reservation bookingRequest) {
        Reservation updatedBooking = reservationService.updateBooking(id, bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        reservationService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
