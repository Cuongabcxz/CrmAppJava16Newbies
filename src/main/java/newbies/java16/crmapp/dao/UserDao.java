package newbies.java16.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import newbies.java16.crmapp.dbconnection.MySqlConnection;
import newbies.java16.crmapp.dto.UserLoginDto;


public class UserDao {
	
	public ArrayList<UserLoginDto> getAll() {
		ArrayList<UserLoginDto> models = new ArrayList<UserLoginDto>();
		String query = "SELECT * FROM crm.user";
		
		try( Connection conn = MySqlConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				UserLoginDto model = new UserLoginDto();
				model.setId(res.getString("id"));
				model.setName(res.getString("name"));
				model.setEmail(res.getString("email"));
				model.setAddress(res.getString("address"));
				model.setPhone(res.getString("phone"));
				model.setRoleId(res.getInt("role_id"));
				models.add(model);				
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return models;
	}
	
	public void insert(UserLoginDto user) {
		
		String query = "INSERT INTO crm.user(name, email, address, phone, password, role_id) values (?,?,?,?,?,?)";
		
		try( Connection conn = MySqlConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getPassword());
			statement.setInt(6, user.getRoleId());
			
			 statement.executeUpdate();		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(String id, String name, String email, String address, String phone, Integer role_id) {
		
		try(Connection conn = MySqlConnection.getConnection()) {
			String query = "UPDATE crm.user set name = ?, email = ?, phone = ?, address = ? , role_id = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, address);
			statement.setString(4, phone);
			statement.setInt(5, role_id);
			statement.setString(6, id);
			statement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	public void delete(String id) {
		String query = "DELETE FROM crm.user WHERE id = ?";
		try (Connection conn = MySqlConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, id);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}
