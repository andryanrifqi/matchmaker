package model;

public class User {

	private String userID;
	private String password;
	// What is this for?
	private String loginStatus;
	private String username;
	private String email;
	
	public User (String userID, String username, String password, 
			String email) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public boolean verifyLogin() {
		// TODO
		
		return false;
	}
}
