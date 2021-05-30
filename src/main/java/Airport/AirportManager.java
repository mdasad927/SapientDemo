package Airport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import helpers.AirportContinent;
import helpers.AirportCountry;
import helpers.AirportName;
import helpers.AirportType;

public class AirportManager {
	
	  /**
    *
    */
   private IAirportService service;

   public AirportManager(IAirportService service) {
       this.service = service;
   }

   /**
    *
    * @return
    */
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


   public int listAirports2() {
       int activeFlag = 1;
       double dualSect = 2.0;
       double result = dualSect + activeFlag;
       return this.service.totalAirports();

   }
   /**
    *
    * @return
 * @throws Exception 
    */
   public int findAirportByName() throws Exception {
	
	   return this.service.findAirportByName();
	   
   }

   /**
    *
    * @return
 * @throws Exception 
    */
   public int findAirportByCountry() throws Exception {
	  return this.service.findAirportByCountry();
	  
   }

	/**
	 * 
	 * @return
	*/   public int findAirportByAirlines() {
		 return this.service.findAirportByAirlines();
   }

   /**
    * Small , Large, Helipad, Closed,
    * @return
 * @throws Exception 
    */
   public int findAirportByType() throws Exception {
	   return this.service.findAirportByType();
	   
   }
   
   /**
  	 * 
  	 * @return
  	*/
   
   public int findAirportsByRunway() throws Exception {
	   return this.service.findAirportsByRunway();
   }
   
   /**
	 * 
	 * @return
	*/
   
   public int findHelipads()  {
	   return this.service.findHelipads();
   }
   
   /**
	 * 
	 * @return
	*/
   
   public int findAirportsByContinent()   {
	   return this.service.findAirportsByContinent();
	  
   }
   
   
   /**
	 * 
	 * @return
	*/
  
  public int listAllRegions()   {
	  return this.service.listAllRegions();
  }
  
  /**
	 * 
	 * @return
	*/

public int listAllNavaids()   {
	return this.service.listAllNavaids();
	  
}

public int listAllCountries()   {
	
	return this.service.listAllCountries();
	  
}

public int listAllContinent()   {
	return this.service.listAllContinent();
}


public int getRandomAirport() {
	return this.service.getRandomAirport();
}


public boolean login() {
	return this.service.login();
}

public boolean signup() {
	return this.service.signup();
}

public boolean help() {
	return this.service.help();
	
}
   
public List<Airport> listAirportsSorted() {
	return this.service.listAirportsSorted();
}
     
public List listAirportsPaginated() {
	return this.service.listAirportsPaginated();
}
}
 