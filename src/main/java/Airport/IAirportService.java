package Airport;

import static org.junit.Assert.fail;

import java.util.List;

public interface IAirportService {
	
	 public int totalAirports();
	 
	 public int findAirportByName();
	 
	 public int findAirportByCountry();
	 
	 public int findAirportByAirlines();
	 
	 public int findAirportByType();
	 
	 public int findAirportsByRunway();
	 
	 public int findHelipads();
	 
	 public int findAirportsByContinent() ;
	 
	 public int listAllRegions() ;
	 
	 public int listAllNavaids();
	 
	 public int listAllCountries();
	 
	 public int listAllContinent();
	 
	 public int listAll();
	 
	 public String getRandomAirport();
	 
	 public boolean login();
	 
	 public boolean signup();
	 
	 public boolean help();
	    
	 public List<Airport> listAirportsSorted();
	      
	 public List listAirportsPaginated();
	 
	 
}
