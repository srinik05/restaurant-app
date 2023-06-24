package com.assignment.restaurantapp.service;


import com.assignment.restaurantapp.constants.TableStatus;
import com.assignment.restaurantapp.entity.Booking;
import com.assignment.restaurantapp.entity.RestaurantTable;
import com.assignment.restaurantapp.exceptions.TableNotAvailableException;
import com.assignment.restaurantapp.repository.BookingRepository;
import com.assignment.restaurantapp.repository.TableRepository;
import com.assignment.restaurantapp.request.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final TableRepository tableRepository;
    private final BookingRepository bookingRepository;

    public BookingService(TableRepository tableRepository, BookingRepository bookingRepository) {
        this.tableRepository = tableRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(BookingRequest bookingRequest) {
        RestaurantTable table = tableRepository.findAvailableTable();
        if (table == null) {
            throw new TableNotAvailableException("No available tables");
        }

        // Business logic to create a booking
        Booking booking = new Booking();
        booking.setCustomerName(bookingRequest.getCustomerName());
        booking.setContactNumber(bookingRequest.getContactNumber());
        booking.setBookingDateTime(bookingRequest.getBookingDateTime());
        booking.setNumberOfGuests(bookingRequest.getNumberOfGuests());
        booking.setTable(table);

        // Additional business logic or validations if needed

        return bookingRepository.save(booking);
    }

    public List<RestaurantTable> getAvailableTables() {
        return tableRepository.findByStatus(TableStatus.AVAILABLE);
    }


}
