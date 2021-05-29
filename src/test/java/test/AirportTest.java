package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Airport.AirportManager;
import Airport.IAirportService;

public class AirportTest {
	
	    IAirportService service =null;

	    @Before
	    public void init() {
	        // mocked the IAirportService.class --->
	        service = Mockito.mock(IAirportService.class);
	        //Mockito.when(service.totalAirports()).thenReturn(100);
	    }

	    @After
	    public void destroy() {
	        System.out.println("After......");
	    }

	    @Test
	    public void testListAllAirports() {
	    	
	        AirportManager manager = new AirportManager(service);
	        int expected = 65509;
	        Mockito.when(service.totalAirports()).thenReturn(65509);
	        assertEquals(expected, manager.listAirports());
	    }
	    
	    @Test
	    public void testListAllAirports1() {
	    	
	        AirportManager manager = new AirportManager(service);
	        int expected = 100;
	        Mockito.when(service.totalAirports()).thenReturn(100);
	        assertEquals(expected, manager.listAirports1());
	    }
	    
	    @Test
	    public void testListAllAirports2() {
	    	
	        AirportManager manager = new AirportManager(service);
	        int expected = 100;
	        Mockito.when(service.totalAirports()).thenReturn(100);
	        assertEquals(expected, manager.listAirports2());
	    }

	    @Test
	    public void testFindAirportsByName() throws Exception {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 1;
	        Mockito.when(service.findAirportByName()).thenReturn(1);
	        assertEquals(expected, manager.findAirportByName());
	    }

	    @Test
	    public void testFindAirportsByCountry() throws Exception {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 312;
	        Mockito.when(service.findAirportByCountry()).thenReturn(312);
	        assertEquals(expected, manager.findAirportByCountry());
	    }
	    
	    @Test
	    public void testFindAirportsByType() throws Exception {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 36534;
	        Mockito.when(service.findAirportByType()).thenReturn(36534);
	        assertEquals(expected, manager.findAirportByType());
	    }
	    
	    @Test
	    public void testFindAirportsByAirlines() {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 100;
	        Mockito.when(service.findAirportByAirlines()).thenReturn(100);
	        assertEquals(expected, manager.findAirportByAirlines());
	    }

	    @Test
	    public void testFindAirportsByRunways() throws Exception {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 100;
	        Mockito.when(service.findAirportsByRunway()).thenReturn(100);
	        assertEquals(expected, manager.findAirportsByRunway());
	    }

	    @Test
	    public void testFindHelipads() {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 12;
	        Mockito.when(service.findHelipads()).thenReturn(12);
	        assertEquals(expected, manager.findHelipads());
	    }

	    @Test
	    public void testFindAirportsByContinent() {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 1150;
	        Mockito.when(service.findAirportsByContinent()).thenReturn(1150);
	        assertEquals(expected, manager.findAirportsByContinent());
	    }

	    @Test
	    public void testListAllRegions() {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 3964;
	        Mockito.when(service.listAllRegions()).thenReturn(3964);
	        assertEquals(expected, manager.listAllRegions());
	    }

	    @Test
	    public void testListAllNavaids() {
	    	AirportManager manager = new AirportManager(service);
	        int expected = 11022;
	        Mockito.when(service.listAllNavaids()).thenReturn(11022);
	        assertEquals(expected, manager.listAllNavaids());
	    }

	    @Test
	    public void testListAll() {
	    	 AirportManager manager = new AirportManager(service);
		        int expected = 65509;
		        Mockito.when(service.totalAirports()).thenReturn(65509);
		        assertEquals(expected, manager.listAirports());
	    }

	    @Test
	    public void testGetRandomAirport() {
	    	AirportManager manager = new AirportManager(service);
	        int expected =6523;
	        Mockito.when(service.getRandomAirport()).thenReturn(6523);
	        assertEquals(expected, manager.getRandomAirport());
	    }
	    @Test
	    public void testListCountries() {
	    	AirportManager manager = new AirportManager(service);
	        int expected =248;
	        Mockito.when(service.listAllCountries()).thenReturn(248);
	        assertEquals(expected, manager.listAllCountries());
	    }

	    @Test
	    public void testListContinents() {
	    	AirportManager manager = new AirportManager(service);
	        int expected =3964;
	        Mockito.when(service.listAllContinent()).thenReturn(3964);
	        assertEquals(expected, manager.listAllContinent());
	    }

	    @Test
	    public void testLogin() {
	    	AirportManager manager = new AirportManager(service);
	        boolean expected =true;
	        Mockito.when(service.login()).thenReturn(true);
	        assertEquals(expected, manager.login());
	    }

	    @Test
	    public void testSignup() {
	    	AirportManager manager = new AirportManager(service);
	        boolean expected =true;
	        Mockito.when(service.signup()).thenReturn(true);
	        assertEquals(expected, manager.signup());
	    }

	    @Test
	    public void testHelps(){
	    	AirportManager manager = new AirportManager(service);
	        boolean expected =true;
	        Mockito.when(service.help()).thenReturn(true);
	        assertEquals(expected, manager.help());
	    }
	    @Test
	    public void listAirportsSorted(){
	    	AirportManager manager = new AirportManager(service);
	    	List<Integer> expected =new ArrayList<>();
	        Mockito.when(service.listAirportsSorted()).thenReturn(expected);
	        assertEquals(expected, manager.listAirportsSorted());
	    }
	    @Test
	    public void listAirportsPaginated(){
	    	AirportManager manager = new AirportManager(service);
	        boolean expected =true;
	        Mockito.when(service.listAirportsPaginated()).thenReturn(true);
	        assertEquals(expected, manager.listAirportsPaginated());
	    }


}
