package ule.ed.service;

import java.util.ArrayList;
import java.util.List;

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
	
	//**************************************************************************
	@Test
	public void testGetNumberOfPeople() throws Exception{
            Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
            Assert.assertEquals(4,res.getNumberOfPeople());
	}
	
	@Test
	public void testGetNumberOfChildren() throws Exception {
		Assert.assertEquals(1, res.occupyTable(4, 2)); // le asigna la mesa 1
		Assert.assertEquals(2, res.getNumberOfChildren());
	}
	
	@Test
	public void testGetName() throws Exception{
		Assert.assertEquals("Casa Pepe", res.getName());
	}
	
	@Test
	public void testGetNumberTablesOccupied() throws Exception {
		Assert.assertEquals(0, res.getNumberTablesOccupied());
		res.occupyTable(4, 0);
		Assert.assertEquals(1, res.getNumberTablesOccupied());
	}
	
	@Test
	public void testNumberFreeTables() throws Exception{
		Assert.assertEquals(15, res.getNumberOfEmptyTables());
		res.occupyTable(4, 0);
		Assert.assertEquals(14, res.getNumberOfEmptyTables());
	}
	
	@Test
	public void testTablesWithChildrens() throws Exception{
		Assert.assertEquals(0, res.getNumberOfTablesWithChildren());
        res.occupyTable(4, 2);
        Assert.assertEquals(1, res.getNumberOfTablesWithChildren());
        res.occupyTable(4, 0);
        Assert.assertEquals(1, res.getNumberOfTablesWithChildren());
	}
	
	@Test
	public void testAddDishToTable() throws Exception {
		res.occupyTable(4, 2);
		res.addDishToTable(1, "Arroz", 10.0, 2);
		Assert.assertEquals(18.0, res.getFinalPrice(1), 0.0);
	}
	
	@Test (expected = Exception.class)
	public void testAddDishToNotExistingTable() throws Exception{
		res.addDishToTable(2, "Arroz", 10.0, 2);
	}
	
	@Test
	public void testEmptyTable() throws Exception {
		res.emptyTable(1);
	}
	
	@Test
	public void testNotEmptyTable() throws Exception {
		res.occupyTable(4, 2);
		res.occupyTable(4, 0);
		res.emptyTable(2);
	}
	
	@Test
	public void testMaxOccupiedTable() throws Exception {
		for (int i = 0; i < 15; i++) {
			Assert.assertEquals(i + 1, res.occupyTable(4, 2));
		}
	}
	
	@Test
	public void testOccupiedTable() throws Exception {
		for (int i = 0; i < 15; i++) {
			res.occupyTable(4, 2);
		}
		Assert.assertEquals(-1, res.occupyTable(4, 2));
	}
	
	@Test
	public void testMaxOccupiedTableSelected() throws Exception {
		Assert.assertEquals(false, res.occupyTable(5, 10, 2));
	}
	
	@Test
	public void testOccupiedTableSelected() throws Exception {
		Assert.assertEquals(false, res.occupyTable(5, 10, 2));
		res.occupyTable(5, 10, 2);
		Assert.assertEquals(true, res.occupyTable(5, 10, 2));

	}


    @Test
    public void testGetNumbersOfEmptyTablesWhenFull() {
        res.occupyTable(4, 2); // Mesa 1
        res.occupyTable(3, 1); // Mesa 2
        res.occupyTable(2, 1); // Mesa 3
        res.occupyTable(5, 0); // Mesa 4
        res.occupyTable(6, 3); // Mesa 5

        Assert.assertTrue(res.getNumbersOfEmptyTables().isEmpty());
    }

    @Test
    public void testGetServiceExistingTable() {
        res.occupyTable(4, 2); // Ocupa la mesa 1
        Assert.assertEquals("{Servicio:4personas,2ninyos, total= 0.0}", res.getService(1).toString());
    }

    @Test
    public void testGetServiceNonExistingTable() {
    	Assert.assertNull(res.getService(1)); // No hay servicio en la mesa 1
    }
}

