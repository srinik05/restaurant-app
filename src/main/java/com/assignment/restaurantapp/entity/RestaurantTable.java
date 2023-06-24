package com.assignment.restaurantapp.entity;

import com.assignment.restaurantapp.constants.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="RESTAURANT_TABLE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other table details and properties

    @Enumerated(EnumType.STRING)
    private TableStatus status;
}

