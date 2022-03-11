package newbies.java16.testConnection;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import newbies.java16.crmapp.dao.AuthDao;
import newbies.java16.crmapp.dao.UserDao;
import newbies.java16.crmapp.dto.UserLoginDto;
@TestInstance(Lifecycle.PER_CLASS)
public class TestAuthDao {
private UserDao dao;
@BeforeAll
public void setup() {
	dao = new UserDao();
}
//	@Test
//public void checkLogin() throws SQLException {
//	String email = "admin";
//	String password = "$2a$12$wnp7Rmh3y6Gnf3TJN..ik.CM5xy8yJXNn.uWn77zwultjxxX4s002";
//	UserLoginDto dto = dao.login(email, password);
//	assertTrue(dto!=null);
//	
//}
//	@Test
//	public void checkUserExist() throws SQLException {
//		String email = "admin";
//		assertFalse(dao.checkUser(email));
//	}
//	@Test
//	public void createUser() throws SQLException {
//		String email ="admin";
//		String password = "admin";
//		String name = "admin";
//		assertTrue(dao.createUser(email, password, name));
//	}

}
