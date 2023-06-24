package com.assignment.restaurantappdemo.service;

import com.assignment.restaurantappdemo.entity.Booking;
import com.assignment.restaurantappdemo.exception.NotFoundException;
import com.assignment.restaurantappdemo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking bookingRequest) {
        // Perform validation and business logic
        //bookingRequest.setConfirmed(false);
        return bookingRepository.save(bookingRequest);
    }

    public Booking updateBooking(Long id, Booking bookingRequest) {
        // Perform validation and business logic
        Booking existingBooking = getBookingById(id);
        // Update existingBooking with the new values from bookingRequest
        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        // Perform validation and business logic
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    public Booking getBookingById(Long id) {
        // Perform validation and business logic
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    public List<Booking> getAllBookings() {
        // Perform validation and business logic
        return bookingRepository.findAll();
    }
}
