package rockmatching;

import db.Database;
import model.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBTests {

	@Test
	public void test_UserLoad() {
		User user = Database.loadUser("1");
		assertEquals(user.getName(), "John");
	}

}
