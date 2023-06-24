package com.assignment.restaurant.app.service;

import com.assignment.restaurant.app.entity.Reservation;
import com.assignment.restaurant.app.model.ReservationRequest;
import com.assignment.restaurant.app.repository.BookingRepository;
import com.assignment.restaurant.app.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final BookingRepository bookingRepository;

    public ReservationService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void saveReservation(ReservationRequest bookingRequest) {
        Reservation reservation = mapToReservationEntity(bookingRequest);
        bookingRepository.save(reservation);
    }

    private Reservation mapToReservationEntity(ReservationRequest bookingRequest) {
        Reservation reservation = new Reservation();
        reservation.setName(bookingRequest.getName());
        reservation.setLocation(bookingRequest.getLocation());
        reservation.setPhone(bookingRequest.getPhone());
        reservation.setEmail(bookingRequest.getEmail());
        reservation.setReservationDate(bookingRequest.getReservationDate());
        reservation.setNoOfGuests(bookingRequest.getNoOfGuests());
        reservation.setTimeSlot(bookingRequest.getTimeSlot());
        reservation.setConfirmed(true);
        return reservation;
    }

    public Reservation updateBooking(Long id, Reservation bookingRequest) {
        // Perform validation and business logic
        Reservation existingBooking = getBookingById(id);
        // Update existingBooking with the new values from bookingRequest
        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        // Perform validation and business logic
        Reservation booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    public Reservation getBookingById(Long id) {
        // Perform validation and business logic
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    public List<Reservation> getAllBookings() {
        // Perform validation and business logic
        return bookingRepository.findAll();
    }
}
