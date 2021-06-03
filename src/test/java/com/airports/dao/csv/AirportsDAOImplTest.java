package com.airports.dao.csv;

import com.airports.dao.IAirportsDAO;
import com.airports.domain.Airport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirportsDAOImplTest {
    IAirportsDAO dao = null;

    @Before
    public void setup() {
        dao = new AirportsDAOImpl();
    }

    @Test
    public void testFindByName() {
        assertNotNull(dao.findByName("London Heathrow Airport"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameBadArg() {
        dao.findByName(null);
    }

    @Test
    public void testFindByType() {
        assertNotNull(dao.findByType("small_airport"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByTypeBadArg() {
        dao.findByType(null);
    }

    @Test
    public void testFindByCountry() {
        assertNotNull(dao.findByCountry("Greece"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByCountryBadArg() {
        dao.findByCountry(null);
    }

    @Test
    public void testFindAll() {
        assertFalse(dao.findAll().isEmpty());
    }

    @Test
    public void testFindById() {
        Long expectedId = 2434L;
        Airport airport = dao.findById(2434L);
        assertEquals(expectedId, airport.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByIdBadArgs() {
        Airport airport = dao.findById(null);
    }

}