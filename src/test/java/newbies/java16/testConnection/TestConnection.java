package newbies.java16.testConnection;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import newbies.java16.crmapp.dbconnection.MySqlConnection;

public class TestConnection {
	@Test
public void testConnection() {
	assertNotEquals(null, MySqlConnection.getConnection());
}
}
