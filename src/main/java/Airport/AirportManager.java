package Airport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.CsvToBeanBuilder;

import helpers.AirportContinent;
import helpers.AirportCountry;
import helpers.AirportName;
import helpers.AirportType;

public class AirportManager implements IAirportService {
	private static Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

	private IAirportService service;

	public AirportManager(IAirportService service) {
		this.service = service;
	}

	public int listAirports() {
		int activeFlag = 1;
		double dualSect = 2.0;
		double result = dualSect + activeFlag;
		return this.service.totalAirports();

	}

	public int listAirports1() {
		int activeFlag = 1;
		double dualSect = 2.0;
		double result = dualSect + activeFlag;
		return this.service.totalAirports();

	}

	@Override
	public int totalAirports() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().count();
		} catch (IOException e) {
			result = 0;
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int findAirportByName() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines()
					.filter(airport -> airport.contains(AirportName.Fulton_Airport.name())).count();
		} catch (IOException e) {
			result = 0;
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int findAirportByCountry() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines()
					.filter(airport -> airport.contains(AirportCountry.MH.name())).count();
		} catch (IOException e) {
			result = 0;
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int findAirportsByRunway() {

		return this.service.findAirportsByRunway();
	}

	@Override
	public int findHelipads() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines()
					.filter(airport -> airport.contains("helipad")).count();
		} catch (IOException e) {
			result = 0;
			logger.error(e.getMessage());
		}
		return result;

	}

	@Override
	public int findAirportsByContinent() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\regions.csv")).lines()
					.filter(airport -> airport.contains(AirportContinent.EU.name())).count();
		} catch (IOException e) {
			result = 0;
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int listAllRegions() {
		int result = 0;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\regions.csv")).lines().count();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int listAllNavaids() {
		int result = 0;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\navaids.csv")).lines().count();
		} catch (IOException e) {
			logger.error(e.getMessage());

		}
		return result;
	}

	@Override
	public int listAllCountries() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\countries.csv")).lines().count();
		} catch (IOException e) {
			logger.error(e.getMessage());
			result = 0;
		}
		return result;
	}

	@Override
	public int listAllContinent() {
		String fileName = "D:\\Learning\\Airport Data\\regions.csv";

		List<Region> beans = null;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Region.class).build().parse();
		} catch (IllegalStateException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		return (int) beans.stream().map(i -> i.getContinent()).distinct().count();

	}

	@Override
	public int listAll() {
		return this.service.totalAirports();
	}

	@Override
	public String getRandomAirport() {
		return this.service.getRandomAirport();
	}

	@Override
	public boolean login() {
		return this.service.login();
	}

	@Override
	public boolean signup() {
		return this.service.signup();
	}

	@Override
	public boolean help() {
		return this.service.help();
	}

	@Override
	public List<Airport> listAirportsSorted() {
		String fileName = "D:\\Learning\\Airport Data\\airports.csv";

		List<Airport> beans = null;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Airport.class).build().parse();
		} catch (IllegalStateException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		beans = beans.stream().sorted((Airport o1, Airport o2) -> o1.getId() - o2.getId()).collect(Collectors.toList());

		return beans;

	}

	@Override
	public List listAirportsPaginated() {
		String fileName = "D:\\Learning\\Airport Data\\airports.csv";

		List<Airport> beans = null;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Airport.class).build().parse();
		} catch (IllegalStateException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		beans = beans.stream().limit(10).collect(Collectors.toList());

		return beans;
	}

	@Override
	public int findAirportByAirlines() {
		return this.service.findAirportByAirlines();
	}

	@Override
	public int findAirportByType() {
		int result;
		try {
			result = (int) Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines()
					.filter(airport -> airport.contains(AirportType.small_airport.name())).count();
		} catch (IOException e) {
			result = 0;
			logger.error(e.getMessage());
		}
		return result;
	}
}
