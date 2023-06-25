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

    /**
     * Get a booking by ID
     * @param id The ID of the booking
     * @return ResponseEntity with the booking if found, or an error response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getBooking(@PathVariable String id) {
        Reservation booking = reservationService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    /**
     * Get all bookings
     * @return ResponseEntity with the list of all bookings, or an error response
     */
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllBookings() {
        List<Reservation> bookings = reservationService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    /**
     * Update a booking
     * @param id The ID of the booking to be updated
     * @param bookingRequest The updated booking details
     * @return ResponseEntity with the updated booking if successful, or an error response
     */
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateBooking(@PathVariable String id, @RequestBody Reservation bookingRequest) {
        Reservation updatedBooking = reservationService.updateBooking(id, bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }

    /**
     * Delete a booking
     * @param id The ID of the booking to be deleted
     * @return ResponseEntity with no content if deletion is successful, or an error response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        reservationService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
