package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.*;

public class Database {
	
	// Settings for SQL connection
	static private String connURL = "jdbc:mysql://localhost:3306/underground_market";
	static private String username = "user";
	static private String password = "pass";
	
	static public User loadUser (String userID) {
		User user = null;
		
		// Try to retrieve from database
		try {
			// Set up the driver for the java to database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// Set up connection
			Connection con=DriverManager.getConnection(connURL, username, 
					password); 
			
			// Send SQL statement
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery(
					"select *"
					+ " from users"
					+ " where `user_id`='" + userID + "'");
			
			while(rs.next()) {
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phoneNum = rs.getString(4);
				String email = rs.getString(5);
				String dob = rs.getString(6);
				String username = rs.getString(7);
				String password = rs.getString(8);
				boolean admin = rs.getBoolean(9);
				String creditCardNum = rs.getString(10);
				if (admin) {
					user = new Administrator(userID, name, address, phoneNum, email, dob, 
							username, password, creditCardNum);
				}
				else {
					user = new User(userID, name, address, phoneNum, email, dob, 
							username, password, creditCardNum);
				}
			}
			
			// Close connection
			con.close();  
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Return the user
		return user;
	}
}
