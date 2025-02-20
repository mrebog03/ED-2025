package ule.ed.service;

import org.junit.*;


public class RestaurantArrayImplTests {

	
	private RestaurantArrayImpl res;
	
	
	@Before
	public void testBefore() throws Exception{
	    res = new RestaurantArrayImpl("Casa Pepe", 15, 100, 10);
	}
	
	@Test
	public void testRestauranteVacio() throws Exception {
		
	    Assert.assertTrue(res.getActualCapacity()==100);
	    Assert.assertEquals(res.getMaxCapacity(),100);
	    Assert.assertEquals(res.getNumberOfChildren(),0);
	}
	
	@Test
	public void testOcupa1Mesa() throws Exception{
		
			
	    Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    Assert.assertEquals(96,res.getActualCapacity());
	    Assert.assertEquals(2,res.getNumberOfChildren());
 
	}

	@Test
	public void testGetTotal1plato() throws Exception{
		
			
	    Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    res.addDishToTable(1,"Arroz", 10.0, 2);
	    Assert.assertEquals(18.0,res.getFinalPrice(1),0.0);
	    Assert.assertEquals(18.0,res.getFinalPriceRestaurant(),0.0);    
	}

	@Test
	public void testGetTotal2platos() throws Exception{
		
			
	    Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    res.addDishToTable(1,"Arroz", 10.0, 2);
	    res.addDishToTable(1,"Macarrones", 10.0, 1);
	    Assert.assertEquals(27.0,res.getFinalPrice(1),0.0);
	    Assert.assertEquals(27.0,res.getFinalPriceRestaurant(),0.0);    
	}
	
}

