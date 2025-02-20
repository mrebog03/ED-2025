package ule.ed.service;

import java.util.ArrayList;

public class Service {
 private ArrayList<Dish> order;
 private int nChildren;
 private int nPeople;
 
 public Service(int nPeople, int nChildren) {
	 this.order = new ArrayList<>();
	 this.nChildren = nChildren;
	 this.nPeople = nPeople;
	 
 }
 
 //Calcula el total de este servicio, tiene que recorrer el array de platos calculando el total de cada plato, teniendo en cuenta que hay una cantidad de esos platos
 // total de un plato = count * price (número de platos * cantidad de platos)
 
 public double getTotalService() {
	 double contador = 0;
	 for(int i = 0; i < this.order.size(); i++) {
		 contador = contador + (this.order.get(i).getPrice() * this.order.get(i).getCount());
	 }
	return contador;
 }
 
public int getNChildren() {
	return this.nChildren;
}

public ArrayList<Dish> getOrder(){
	return this.order;
}

public void addDishToTable(String name, double price, int count) {
	Dish element = new Dish(name, price);
	boolean encontrado = false;
	
	if(this.order.isEmpty()) {
		this.order.add(element);
		this.order.get(0).setCount(count);
		this.order.get(0).setPrice(price);
		this.order.get(0).setName(name);
	}else {
		for(int i = 0; i < this.order.size(); i++) {
			if(this.order.get(i) == element) {
				encontrado = true;
				this.order.get(i).setCount(this.order.get(i).getCount()+1);
			}
		}
		if(!encontrado) {
			this.order.add(element);
			this.order.get(this.order.size()-1).setCount(count);
			this.order.get(this.order.size()-1).setPrice(price);
			this.order.get(this.order.size()-1).setName(name);
		}
	}
}
 
 @Override
	public String toString() {
		return "{Servicio:" + nPeople +"personas," +nChildren + "ninyos, total= "+ getTotalService() + "}";
	}

}
