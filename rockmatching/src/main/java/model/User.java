package model;

public class User {

	private String userID;
	private String name;
	private String address;
	private String phoneNum;
	private String email;
	private String dob;
	private String username;
	private String password;
	private String creditCardNum;
	
	public User (String userID, String name, String address, String phoneNum,
			String email, String dob, String username, String password,
			String creditCardNum) {
		this.userID = userID;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.creditCardNum = creditCardNum;
	}
	
	public String getName () {
		return this.name;
	}
	
	public boolean verifyLogin() {
		// TODO
		
		return false;
	}
}
