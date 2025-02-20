package ule.ed.service;

import java.util.List;

public interface IRestaurant {
	
	// Devuelve el nombre del restaurante
	public String getName();
	
	// Devuelve el aforo máximo permitido 
	public int getMaxCapacity();
	
	//Devuelve el número de niños que hay en el restaurante ocupando alguna mesa
	public int getNumberOfChildren();
			
         //Devuelve el número de personas que hay en el restaurante ocupando alguna mesa
	public int getNumberOfPeople();
		
	// Devuelve el número de clientes totales que hay en el restaurante 
	public int getActualCapacity();
	
	//Calcula el número de mesas ocupadas 
	public int getNumberTablesOccupied();
		
	//Calcula el número de mesas vacías (no ocupadas)
	public int getNumberOfEmptyTables();

	//Devuelve el número de mesas ocupadas que tienen algún niño
	public int getNumberOfTablesWithChildren();
	
	// Devuelve una lista de enteros, con el número de las mesas vacías
	public List<Integer> getNumbersOfEmptyTables();
		
	// Devuelve el servicio que hay en el número de mesa indicado 
	// Devuelve null si la mesa no está ocupada
	// Las mesas empiezan en el número 1
	public Service getService(int ntable);
	
	// añade un plato a un servicio (una comanda) de una mesa
	// Si ya existe un plato en esa comanda con ese mismo nombre y precio, 
          // simplemente incrementa el número de platos
	// si no existe, lo añade a la lista de platos de la mesa.
	// count indica el número de dicho plato añadidos
	public void addDishToTable(int nTable, String name, double price, int count);
	
	// Devuelve el precio final del servicio de la mesa ntable después de aplicarle el descuento del día
	public double getFinalPrice(int ntable);
	
	// Devuelve la suma del precio final de cada servicio de las mesas ocupadas con el descuento del día
	public double getFinalPriceRestaurant();
		
	

	/**
	 * Vacía la mesa con el número indicado. 
	 * 
           * Si la mesa con ese número ya está vacía, o si el número no es válido, devuelve false.
           * Si se pudo vaciar la mesa devuelve true
	 * 
	 * Los números de mesa empiezan en '1'.
	 * 
	 * @param nTable
	 * @return true: si la mesa estaba ocupada
	 *              o false si la mesa no estaba ocupada o si el número de mesa no era válido.
	 * 
	 */
	public boolean emptyTable(int nTable);


	/**
	 * Devuelve el número de mesa a ocupar teniendo en cuenta que :
	 * - el aforo máximo permita añadir el número de personas indicado como parámetro
	 * - buscará la mesa con el número más bajo que no esté ocupada 
	 *   
	 * 
	 * Las posiciones empiezan en '1'.
	 * 
	 * @param nChildren : número de niños que habrá en la mesa
	 * @param nPeople : número de personas incluyendo niños que habrá en la mesa
	 * @return el número de mesa que le asigna 
	 *         -1 si el aforo no permite sentar a ese número de personas
	 *         -2 si no se puede encontrar una mesa libre  
	 */
	public int occupyTable(int nPeople, int nChildren);
	
          /**
	 * Devuelve True si puede ocupar la mesa indicada por el notable :
	 * - el aforo máximo permita añadir el número de personas indicado como parámetro
	 * - la mesa con el número nTable no esté ocupada 
	 *   
	 * o False en caso contrario
	 * 
	* @param nTable : número de la mesa a ocupar
	 * @param nChildren : número de niños que habrá en la mesa
	 * @param nPeople : número de personas incluyendo niños que habrá en la mesa
	 * @return true o false, dependiendo de si puede ocupar la mesa o no 
	 *    
	 */

	public boolean occupyTable(int nTable, int nPeople, int nChildren);
	
 	
	
}
