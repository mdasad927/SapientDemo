package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import Airport.AirportManager;
import Airport.IAirportService;

public class AirportTest {
	 IAirportService service= Mockito.mock(IAirportService.class);

	    @Before
	    public void init(){
	        System.out.println("Before ");
	        // this method gets invoked before every test case
	        //  data populator / scene populates
	    }

	    @After
	    public void destroy(){
	        // after each test case
	        System.out.println("After......");
	    }

	    @Test
	    public void testListAllAirports(){
	        // i mocked the data for the service .
	        Mockito.when(service.totalAirports()).thenReturn(100);
	        AirportManager manager = new AirportManager(service);
	        int expected = 100;
	        assertEquals( expected, manager.listAirports());

	    }
	    @Test
	    @Ignore
	    public void testFindAirportsByName(){
	        fail("Not Yet Impemented");
	    }
	    @Test
	    @Ignore
	    public void testFindAirportsByCountry(){
	        fail("Not Yet Impemented");
	    }
	    @Test
	    @Ignore
	    public void testFindAirportsBySize(){
	        fail("Not Yet Impemented");
	    }
	    @Test
	    @Ignore
	    public void testFindAirportsByRunways(){
	        fail("Not Yet Impemented");
	    }
	    @Test
	    @Ignore
	    public void testFindHelipads(){
	        fail("Not Yet Impemented");
	    }
}
