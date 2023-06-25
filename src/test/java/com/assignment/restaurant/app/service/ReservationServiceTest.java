package com.assignment.restaurant.app.service;

import com.assignment.restaurant.app.entity.Reservation;
import com.assignment.restaurant.app.model.ReservationRequest;
import com.assignment.restaurant.app.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    public void testSaveReservation() {
        ReservationRequest reservationRequest = new ReservationRequest();

        reservationService.saveReservation(reservationRequest);

        verify(reservationRepository, times(1)).save(any(Reservation.class));
    }

    @Test
    public void testUpdateBooking() {
        String bookingId = "123";
        Reservation bookingRequest = new Reservation();
        // Set the necessary fields in the bookingRequest object

        Reservation existingBooking = new Reservation();
        // Set the necessary fields in the existingBooking object
        when(reservationRepository.findById(bookingId)).thenReturn(Optional.of(existingBooking));
        when(reservationRepository.save(existingBooking)).thenReturn(existingBooking);

        Reservation updatedBooking = reservationService.updateBooking(bookingId, bookingRequest);

        // Verify that the save method of the reservationRepository was called with the existingBooking entity
        verify(reservationRepository, times(1)).save(existingBooking);
        assertEquals(existingBooking, updatedBooking);
    }

    @Test
    public void testDeleteBooking() {
        String bookingId = "123";
        Reservation booking = new Reservation();
        // Set the necessary fields in the booking object
        when(reservationRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        reservationService.deleteBooking(bookingId);

        // Verify that the delete method of the reservationRepository was called with the booking entity
        verify(reservationRepository, times(1)).delete(booking);
    }

    @Test
    public void testGetBookingById() {
        String bookingId = "123";
        Reservation booking = new Reservation();
        // Set the necessary fields in the booking object
        when(reservationRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        Reservation retrievedBooking = reservationService.getBookingById(bookingId);

        assertEquals(booking, retrievedBooking);
    }

    @Test
    public void testGetAllBookings() {
        List<Reservation> bookings = Arrays.asList(

        );
        when(reservationRepository.findAll()).thenReturn(bookings);

        List<Reservation> retrievedBookings = reservationService.getAllBookings();

        assertEquals(bookings, retrievedBookings);
    }
}
