package newbies.java16.crmapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

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
		}
	} catch (Exception e) {
		System.out.println("Couldn't excute query");
	} finally {
		connection.close();
	}
	return dto;
}

public boolean checkUser(String email) throws SQLException {
	Connection connection = MySqlConnection.getConnection();
	String query = "SELECT email FROM user WHERE email LIKE ?";
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return false;
		}
	} catch (SQLException e) {
	System.out.println("Couldn't excute query");
	}finally {
		connection.close();
	}
	return true;
}
public boolean createUser(String email, String password, String name) throws SQLException {
	Connection connection = MySqlConnection.getConnection();
	String query="INSERT INTO user (email,password,name) VALUES (?,?,?)";
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, name);
		int result = preparedStatement.executeUpdate();
		if (result>0) {
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Couldn't excute query");
	}finally {
		connection.close();
	}
	return false;
}
}
