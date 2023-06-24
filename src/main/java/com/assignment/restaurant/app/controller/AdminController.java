package com.assignment.restaurant.app.controller;


import com.assignment.restaurant.app.entity.Reservation;
import com.assignment.restaurant.app.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/bookings")
public class AdminController {

    private final ReservationService bookingService;

    public AdminController(ReservationService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getBooking(@PathVariable String id) {
        Reservation booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllBookings() {
        List<Reservation> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateBooking(@PathVariable String id, @RequestBody Reservation bookingRequest) {
        Reservation updatedBooking = bookingService.updateBooking(id, bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
