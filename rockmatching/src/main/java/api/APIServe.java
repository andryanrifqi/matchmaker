package api;

import model.User;
import db.Database;

import static spark.Spark.*;

import java.util.ArrayList;

import spark.Request;
import spark.Response;

import com.google.gson.Gson;

public class APIServe {

	public static void main(String[] args) {
        
    	// Configure Spark
        port(4567);

        // Routes
        get("/hello", (req, res) -> "Hello World!");
        get("/user/:id", (req, res) -> GetUser(req, res));
	}

	public static String GetUser (Request req, Response res) {
		
		// Load user
		User user = Database.loadUser(req.params(":id"));
        
        // Make a JSON converter
        Gson gson = new Gson();
        
        // Return user
        if (user != null) {
        	return gson.toJson(user);
        }
        else {
        	res.status(404);
        	return "User not found.";
        }
	}
}
