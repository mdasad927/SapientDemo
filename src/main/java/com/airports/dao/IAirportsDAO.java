package com.airports.dao;

import com.airports.domain.Airport;

import java.util.List;

/**
 * program with interfaces --->
 * a) you can mock
 * b) you can have the closed but open requirements -->
 * c) the Test cases generated in tooling sense
 * d) the implementation can vary but the requirement is conformance
 */
public interface IAirportsDAO extends IDAO<Airport> {
    List<Airport> findByName(String name);
    List<Airport> findByType(String name);
    List<Airport> findByCountry(String country);
}
