package com.assignment.restaurant.app.controller;

import com.assignment.restaurant.app.entity.Reservation;
import com.assignment.restaurant.app.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private AdminController adminController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testGetBooking() throws Exception {
        String bookingId = "123";
        Reservation reservation = new Reservation();
        reservation.setId(bookingId);
        when(reservationService.getBookingById(bookingId)).thenReturn(reservation);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/bookings/{id}", bookingId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(bookingId));
    }

    @Test
    public void testGetAllBookings() throws Exception {
        LocalDate date = LocalDate.of(2023, 6, 30);

        List<Reservation> bookings = Arrays.asList(
        );
        when(reservationService.getAllBookings()).thenReturn(bookings);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/bookings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Booking 1"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].name").value("Booking 2"));
    }
    @Test
    public void testUpdateBooking() throws Exception {
        String bookingId = "123";
        Reservation bookingRequest = new Reservation();
        bookingRequest.setName("Updated Booking");
        Reservation updatedBooking = new Reservation();
        updatedBooking.setId(bookingId);
        updatedBooking.setName("Updated Booking");

        when(reservationService.updateBooking(eq(bookingId), any(Reservation.class))).thenReturn(updatedBooking);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/bookings/{id}", bookingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Booking\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(bookingId))
                .andExpect(jsonPath("$.name").value("Updated Booking"));
    }

    @Test
    public void testDeleteBooking() throws Exception {
        String bookingId = "123";

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/bookings/{id}", bookingId))
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));

        verify(reservationService, times(1)).deleteBooking(bookingId);
    }
}