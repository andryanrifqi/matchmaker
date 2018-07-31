package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.*;

public class Database {
	
	// Settings for SQL connection
	private String connURL = "jdbc:mysql://localhost:3306/java_test";
	private String username = "user";
	private String password = "pass";
	
	public User loadUser (String userID) {
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
					"select username, password, email"
					+ " from user"
					+ " where `userID`='" + userID + "'");
			
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				user = new User(userID, username, password, email);
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
