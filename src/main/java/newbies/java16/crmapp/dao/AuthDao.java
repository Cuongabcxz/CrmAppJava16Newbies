package newbies.java16.crmapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import newbies.java16.crmapp.dbconnection.MySqlConnection;
import newbies.java16.crmapp.dto.UserLoginDto;

public class AuthDao {
public UserLoginDto login(String email, String password) throws SQLException {
	Connection connection = MySqlConnection.getConnection();
	UserLoginDto dto = null;
	try  {
		String query  = "SELECT email,password FROM user WHERE email LIKE ? AND password LIKE ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			dto = new UserLoginDto();
			dto.setEmail(result.getString(1));
			dto.setPassword(result.getString(2));
			return dto;
		}
	} catch (Exception e) {
		System.out.println("Database connection couldn't be established");
	} finally {
		connection.close();
	}
	return dto;
}
}
