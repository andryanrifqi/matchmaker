package apitest;

import java.util.ArrayList;

public class Basket {

	private String id;
	private ArrayList<Fruit> fruits = new ArrayList<Fruit>();
	
	public Basket(String id) {
		this.id = id;
	}
	
	public String GetId() {
		return id;
	}
	
	public void AddFruit (Fruit fruit) {
		this.fruits.add(fruit);
	}
}
