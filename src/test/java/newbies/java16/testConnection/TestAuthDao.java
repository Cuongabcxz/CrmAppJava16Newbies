package newbies.java16.testConnection;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import newbies.java16.crmapp.dao.AuthDao;
import newbies.java16.crmapp.dto.UserLoginDto;
@TestInstance(Lifecycle.PER_CLASS)
public class TestAuthDao {
private AuthDao dao;
@BeforeAll
public void setup() {
	dao = new AuthDao();
}
	@Test
public void checkLogin() throws SQLException {
	String email = "ngochk@gmail.com";
	String password = "ngoc123";
	UserLoginDto dto = dao.login(email, password);
	assertTrue(dto!=null);
	
}
}
