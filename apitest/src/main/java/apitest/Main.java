package apitest;

import static spark.Spark.*;

import java.util.ArrayList;

import spark.Request;
import spark.Response;

import com.google.gson.Gson;

// This program can be tested on any computer. Just go to
// localhost:3456/hello and localhost:3456/basket/[id] while
// the program is running.

public class Main {
	
	public static ArrayList<Basket> baskets = new ArrayList<Basket>();
	
    public static void main(String[] args) {
        
        // Make fruits
    	Fruit[] fruits = new Fruit[4];
    	fruits[0] = new Fruit("1", "apple");
    	fruits[1] = new Fruit("2", "orange");
    	fruits[2] = new Fruit("3", "banana");
    	fruits[3] = new Fruit("4", "pear");
    	
        // make baskets
    	Basket basket1 = new Basket("1");
    	basket1.AddFruit(fruits[0]);
    	basket1.AddFruit(fruits[1]);
        baskets.add(basket1);
    	Basket basket2 = new Basket("2");
    	basket2.AddFruit(fruits[2]);
    	basket2.AddFruit(fruits[3]);
        baskets.add(basket2);
        
    	// Configure Spark
        port(4567);

        get("/hello", (req, res) -> HelloWorld());
        
        get("/basket/:id", (req, res) -> GetBasket(req, res));
    }
    
    public static String HelloWorld() {
    	return "Hello World!";
    }
    
    // This is a testing function
    public static String CheckParam (Request req, Response res, String param) {
    	return req.params(param);
    }
    
    public static String GetBasket (Request req, Response res) {
    	
        // Find basket
        Basket basket = null;
        for (Basket b : baskets) {
        	if (b.GetId().equals(req.params(":id"))) {
        		basket = b;
        	}
        }	
        
        // Make a JSON converter
        Gson gson = new Gson();
        
        if (basket != null) {
        	return gson.toJson(basket);
        }
        else {
        	res.status(404);
        	return "Basket not found.";
        }
    }
}
