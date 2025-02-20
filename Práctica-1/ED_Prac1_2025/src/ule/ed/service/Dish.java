package ule.ed.service;

public class Dish {
  private String name;	
  private double price;
  private int count;

public Dish(String name, double price) {
	this.name=name;
	this.price=price;
}
public String getName() {
	return this.name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return this.price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getCount() {
	return this.count;
}
public void setCount(int count) {
	this.count = count;
}

}
