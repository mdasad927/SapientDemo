package com.airports.db;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AirportsInMemoryDBTest {

    @Test
    public void airports() {
        assertNotNull(AirportsInMemoryDB.airports());
    }

    @Test
    public void navaids() {
        assertNotNull(AirportsInMemoryDB.navaids());
    }

    @Test
    public void countries() {
        assertNotNull(AirportsInMemoryDB.countries());
    }

    @Test
    public void regions() {
        assertNotNull(AirportsInMemoryDB.regions());
    }
}