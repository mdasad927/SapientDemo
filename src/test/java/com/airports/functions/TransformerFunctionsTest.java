package com.airports.functions;

import org.junit.Test;

public class TransformerFunctionsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testStringToAirportBadArg() {
        TransformerFunctions.stringToAirport(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringToCountryBadArg() {
        TransformerFunctions.stringToCountry(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringToRegionBadArg() {
        TransformerFunctions.stringToRegion(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringToNavaidBadArg() {
        TransformerFunctions.stringToNavaid(null);
    }
}