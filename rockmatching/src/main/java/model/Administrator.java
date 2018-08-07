package model;

public class Administrator extends User {
	
	public Administrator (String userID, String name, String address, 
			String phoneNum, String email, String dob, String username, 
			String password, String creditCardNum) {
		super(userID, name, address, phoneNum, email, dob, 
				username, password, creditCardNum);
	}

	public boolean updateCatalog () {
		// TODO
		
		return false;
	}
	
	public boolean updateUser () {
		// TODO
		
		return false;
	}
}
