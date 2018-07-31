package model;

import java.util.ArrayList;

public class Order {

	private String orderID;
	private String dateCreated;
	private String dateShipped;
	private Customer customer;
	private ShippingInfo shippingInfo;
	private String status;
	private ArrayList<Item> items;
	
	public boolean placeOrder () {
		// TODO
		
		return false;
	}
}
