package ule.ed.service;

import java.util.List;
import java.util.ArrayList;

public class RestaurantArrayImpl implements IRestaurant {

	// ATRIBUTOS
	
	private String name;
	private int nTables;
	private int maxCapacity; // máximo número de clientes admitidos
	private int nClients; // contador de clientes actuales en el restaurante

	private int discount;    // Descuento a aplicar (ejemplo: 10%)

	private Service[] tables; // array de servicios (cada servicio se corresponde con una mesa)
	                          


	// CONSTRUCTOR

	public RestaurantArrayImpl(String name, int nTables,int aforoMax, int discount){ 
		// Debe crear el array de mesas con todas las posiciones a null
		this.name = name;
		this.nTables = nTables;
		this.maxCapacity = aforoMax;
		this.discount = discount;
		this.nClients = 0;
		
		this.tables = new Service[this.nTables];
	}



	@Override
	public String getName() {
		return this.name;
		
	}



	@Override
	public int getMaxCapacity() {
		return maxCapacity;
	}



	@Override
	public int getNumberOfChildren() {
		int numberOfChildren = 0;
		for(int i = 0; i < nTables; i++) {
			if(tables[i] != null) {
			numberOfChildren += tables[i].getNChildren();
			}
		}
		return numberOfChildren;
	}



	@Override
	public int getNumberOfPeople() {
		return nClients;
	}




	@Override
	public int getActualCapacity() {
		return this.maxCapacity - getNumberOfPeople();
	}



	@Override
	public int getNumberTablesOccupied() {
		int tablesOccupied = 0;
		
		for (int i = 0; i < nTables; i++) {
			if (tables[i] != null) {
				tablesOccupied++;
			}
		}
		
		return tablesOccupied;
	}



	@Override
	public int getNumberOfEmptyTables() {
		return this.nTables - getNumberTablesOccupied();
	}



	@Override
	public int getNumberOfTablesWithChildren() {
		int tablesWithChildren = 0;
		
		for (int i = 0; i < nTables; i++) {
			if (tables[i] != null) {
				if(tables[i].getNChildren() > 0){
				tablesWithChildren++;
				}
			}
		}
		return tablesWithChildren;
	}



	@Override
	public List<Integer> getNumbersOfEmptyTables() {
		List<Integer> lista = new ArrayList<>();
		
		return lista;
	}



	@Override
	public Service getService(int ntable) {
		return this.tables[ntable - 1];
	}



	@Override
	public void addDishToTable(int nTable, String name, double price, int count) {
		if (tables[nTable - 1] != null) {
			tables[nTable - 1].addDishToTable(name, price, count);
		} else {
			throw new IllegalArgumentException("La mesa no está ocupada");
		}
	}



	@Override
	public double getFinalPrice(int ntable) {
		double finalPrice = 0.0;
		tables[ntable - 1].getOrder();
		for (int i = 0; i < tables[ntable - 1].getOrder().size(); i++) {
			finalPrice += (tables[ntable - 1].getOrder().get(i).getPrice() * tables[ntable - 1].getOrder().get(i).getCount());
		}
		return finalPrice - (finalPrice * discount / 100);
	}



	@Override
	public double getFinalPriceRestaurant() {
		double finalPrice = 0.0;
		for(int i = 0; i < nTables; i++) {
			if(tables[i] != null) {
				finalPrice += getFinalPrice(i + 1);
			}
		}
		return finalPrice;
    }



	@Override
	public boolean emptyTable(int nTable) {
		if (tables[nTable - 1] != null) {
			return false;
		}
	return true;
	}



	@Override
	public int occupyTable(int nPeople, int nChildren) {
		for(int i = 0; i < this.nTables; i++) {
			if(tables[i] == null) {
				tables[i] = new Service(nPeople, nChildren);
				nClients += nPeople;
				return i + 1;
			}
		}
		return -1;
	}
	
	@Override
	public boolean occupyTable(int nTable, int nPeople, int nChildren) {
		if(tables[nTable] != null) {
			return true;
		} else {
			tables[nTable] = new Service(nPeople, nChildren);
			nClients += nPeople;
		}
		return false;
	}
	
}