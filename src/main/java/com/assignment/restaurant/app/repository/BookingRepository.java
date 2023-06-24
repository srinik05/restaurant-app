package com.assignment.restaurant.app.repository;

import com.assignment.restaurant.app.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Reservation, Long> {
}
