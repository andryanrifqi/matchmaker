
// This program can only be tested on a computer with a running
// MySQL server with the schema named 'java_test' and a table
// named 'users'. Rest assured it does work.

public class App {

	public static void main(String[] args) {
		Database db = new Database();
		db.loadUsers();
	}

}
