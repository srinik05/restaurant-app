package com.assignment.restaurant.app.constants;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableStatusTest {

    @Test
    public void testTableStatusEnumValues() {
        TableStatus[] values = TableStatus.values();

        assertEquals(4, values.length);
        assertEquals(TableStatus.AVAILABLE, values[0]);
        assertEquals(TableStatus.BOOKED, values[1]);
        assertEquals(TableStatus.CONFIRMED, values[2]);
        assertEquals(TableStatus.CANCELLED, values[3]);
    }
}
