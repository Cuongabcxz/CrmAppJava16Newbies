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
				model.setId(res.getInt("id"));
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
	
	public UserLoginDto findUserByEmail(String email) {
		String query = "SELECT * FROM crm.user WHERE email like ?";
		UserLoginDto dto=null;
		try( Connection connection = MySqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				dto = new UserLoginDto();
				dto.setId(res.getInt("id"));
				dto.setName(res.getString("name"));
				dto.setEmail(res.getString("email"));
				dto.setAddress(res.getString("address"));
				dto.setPhone(res.getString("phone"));
				dto.setRoleId(res.getInt("role_id"));
			}
			return dto;
		} catch(Exception e) {
			System.out.println("Could not connect to DB");
		}
		return dto;
	}
	public boolean create(UserLoginDto user) {
		
		String query = "INSERT INTO crm.user(name, email, address, phone, password, role_id) values (?,?,?,?,?,?)";
		
		try( Connection conn = MySqlConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getPassword());
			statement.setInt(6, user.getRoleId());
			System.out.println(user.getRoleId());
			int result=statement.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
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
