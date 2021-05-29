package Airport;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import helpers.AirportContinent;
import helpers.AirportCountry;
import helpers.AirportName;
import helpers.AirportType;

public class AirportServiceImpl implements IAirportService {

	private static Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);
	
	@Override
	public int totalAirports() {
		   int result;
			try {
				result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().count();
			} catch (IOException e) {
				result=0;
				logger.error(e.getMessage());
			}
			   return result;
		  }
	

	@Override
	public int findAirportByName() {
		int result;
		try {
			result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(airport->airport.contains(AirportName.Fulton_Airport.name())).count();
		} catch (IOException e) {
			result=0;
			logger.error(e.getMessage());
		}
		   return result;
	}

	@Override
	public int findAirportByCountry() {
		int result;
		try {
			result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(airport->airport.contains(AirportCountry.MH.name())).count();
		} catch (IOException e) {
			result=0;
			logger.error(e.getMessage());
		}
		   return result;
	}

	@Override
	public int findAirportsByRunway() {
		
		return 0;
	}


	@Override
	public int findHelipads() {
		   int result;
			try {
				result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(airport->airport.contains("helipad")).count();
			} catch (IOException e) {
				result=0;
				logger.error(e.getMessage());
			}
			   return result;
		   
	}


	@Override
	public int findAirportsByContinent() {
		 int result;
			try {
				result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\regions.csv")).lines().filter(airport->airport.contains(AirportContinent.EU.name())).count();
			} catch (IOException e) {
				result=0;
				logger.error(e.getMessage());
			}
			   return result;
	}


	@Override
	public int listAllRegions() {
		/*
		 * int result; try { result =
		 * (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\regions.csv")).
		 * lines().count(); } catch (IOException e) { result=0;
		 * logger.error(e.getMessage()); } return result;
		 */
		return 0;
	}


	@Override
	public int listAllNavaids() {
		 int result;
			try {
				result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\navaids.csv")).lines().count();
			} catch (IOException e) {
				logger.error(e.getMessage());
				result=0;
			}
			   return result;
	}


	@Override
	public int listAllCountries() {
		 int result;
			try {
				result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\countries.csv")).lines().count();
			} catch (IOException e) {
				logger.error(e.getMessage());
				result=0;
			}
			   return result;
	}


	@Override
	public int listAllContinent() {
	
		return 0;
	}


	@Override
	public int listAll() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getRandomAirport() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean signup() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean help() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public List<Integer> listAirportsSorted() {
		/*
		 * List<Integer> result; try { result =
		 * (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).
		 * lines().mapToInt(null).sorted().collect(Collectors.toList()); } catch
		 * (IOException e) { result=0; logger.error(e.getMessage()); }
		 *  
		 * 
		 */
		return new ArrayList();
				 
	}


	@Override
	public boolean listAirportsPaginated() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public int findAirportByAirlines() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findAirportByType() {
		int result;
		try {
			result = (int)Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(airport->airport.contains(AirportType.small_airport.name())).count();
		} catch (IOException e) {
			result=0;
			logger.error(e.getMessage());
		}
		   return result;
	}

}
