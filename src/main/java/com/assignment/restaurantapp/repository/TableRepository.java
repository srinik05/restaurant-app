package com.assignment.restaurantapp.repository;

import com.assignment.restaurantapp.constants.TableStatus;
import com.assignment.restaurantapp.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<RestaurantTable, Long> {
    List<RestaurantTable> findByStatus(TableStatus status);

    @Query(value = "SELECT * FROM restaurant_table t WHERE t.status = 'AVAILABLE' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    RestaurantTable findAvailableTable();
}