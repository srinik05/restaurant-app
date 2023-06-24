package com.assignment.restaurantapp.controller;

import com.assignment.restaurantapp.entity.Booking;
import com.assignment.restaurantapp.entity.RestaurantTable;
import com.assignment.restaurantapp.exceptions.TableNotAvailableException;
import com.assignment.restaurantapp.request.BookingRequest;
import com.assignment.restaurantapp.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            Booking booking = bookingService.createBooking(bookingRequest);
            return ResponseEntity.ok(booking);
        } catch (TableNotAvailableException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/tables/available")
    public ResponseEntity<List<RestaurantTable>> getAvailableTables() {
        try {
            List<RestaurantTable> availableTables = bookingService.getAvailableTables();
            return ResponseEntity.ok(availableTables);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
