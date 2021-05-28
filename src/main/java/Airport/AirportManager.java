package Airport;

public class AirportManager {
	
	   private IAirportService service;

	    public AirportManager(IAirportService service){
	        this.service = service;
	    }


	    public int listAirports(){
	        return this.service.totalAirports();
	    }

}
