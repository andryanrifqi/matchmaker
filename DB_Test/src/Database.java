
import java.sql.*;

public class Database {
	
	// Settings for SQL connection
	private String connURL = "jdbc:mysql://localhost:3306/java_test";
	private String username = "user";
	private String password = "pass";
	
	public void loadUsers () {
		
		try {
			// Set up the driver for the java to database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// Set up connection
			Connection con=DriverManager.getConnection(connURL, username, 
					password); 
			
			// Send SQL statement
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select * from user");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)); 
			}
			
			// Close connection
			con.close();  
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
