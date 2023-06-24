package com.assignment.restaurant.app.service;

import com.assignment.restaurant.app.entity.Reservation;
import com.assignment.restaurant.app.model.ReservationRequest;
import com.assignment.restaurant.app.repository.ReservationRepository;
import com.assignment.restaurant.app.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(ReservationRequest bookingRequest) {
        Reservation reservation = mapToReservationEntity(bookingRequest);
        reservationRepository.save(reservation);
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

    public Reservation updateBooking(String id, Reservation bookingRequest) {
        // Perform validation and business logic
        Reservation existingBooking = getBookingById(id);
        // Update existingBooking with the new values from bookingRequest
        return reservationRepository.save(existingBooking);
    }

    public void deleteBooking(String id) {
        // Perform validation and business logic
        Reservation booking = getBookingById(id);
        reservationRepository.delete(booking);
    }

    public Reservation getBookingById(String id) {
        // Perform validation and business logic
        return reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    public List<Reservation> getAllBookings() {
        // Perform validation and business logic
        return reservationRepository.findAll();
    }
}
