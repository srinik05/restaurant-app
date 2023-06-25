package com.assignment.restaurant.app.controller;

import com.assignment.restaurant.app.model.ReservationRequest;
import com.assignment.restaurant.app.model.ReservationResponse;
import com.assignment.restaurant.app.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationservice;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReserveTable() throws Exception {
        LocalDate date = LocalDate.of(2023, 6, 30);

        ReservationRequest request = new ReservationRequest("John Doe",
                "Restaurant ABC", "1234567890", "johndoe@example.com",date,5, "13:00" );
        ReservationResponse response = new ReservationResponse("Reservation created successfully");

        doNothing().when(reservationservice).saveReservation(request);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) ;
        verify(reservationservice).saveReservation(request);
    }
}
