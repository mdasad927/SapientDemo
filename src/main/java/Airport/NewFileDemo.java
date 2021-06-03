package Airport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;

import helpers.AirportCountry;
import helpers.AirportType;

public class NewFileDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(NewFileDemo::smallAirports).count());;
        System.out.println(Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(NewFileDemo::largeAirports).count());;
        System.out.println(Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(NewFileDemo::heliports).count());;
        System.out.println(Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(NewFileDemo::closed).count());;
        System.out.println(Files.readString(Paths.get("D:\\Learning\\Airport Data\\airports.csv")).lines().filter(NewFileDemo::seaplaneBases).count());;
        
        
		/*
		 * String fileName = "D:\\Learning\\Airport Data\\regions.csv";
		 * 
		 * List<Region> beans = new CsvToBeanBuilder(new FileReader(fileName))
		 * .withType(Region.class) .build() .parse(); // System.out.println(beans);
		 * System.out.println(
		 * (int)beans.stream().map(i->i.getContinent()).distinct().count());
		 */
        //beans.forEach(System.out::println);
        
        String fileName = "D:\\Learning\\Airport Data\\airports.csv";

        List<Airport> beans=null;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(Airport.class)
			        .build()
			        .parse();
		} catch (IllegalStateException e) {
			//logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			//logger.error(e.getMessage());
		}
      
		beans= beans.stream().sorted((Airport o1, Airport o2) -> o1.getId()-o2.getId()
		        ).collect(Collectors.toList());
		//beans.sort((Airport s1, Airport s2)->s1.getId().compareTo(s2.getId()));
		//beans.sort((Airport s1, Airport s2)->s1.getId()-s2.getId());
	System.out.println(beans.get(0).getId()); 
	System.out.println(beans.get(1).getId()); 
	}
    public static boolean smallAirports(String airport) {
        return airport.contains(AirportType.small_airport.name());
    }

    public static boolean largeAirports(String airport) {
        return airport.contains(AirportType.large_airport.name());
    }
    public static boolean heliports(String airport) {
        return airport.contains(AirportType.heliport.name());
    }
    public static boolean closed(String airport) {
        return airport.contains(AirportType.closed.name());
    }
    public static boolean seaplaneBases(String airport) {
        return airport.contains(AirportType.seaplane_base.name());
    }
    
    public static boolean findAirportsByCountry(String airport) {
        return airport.contains(AirportCountry.MH.name());
    }

	}


