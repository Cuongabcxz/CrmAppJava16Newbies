package newbies.java16.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newbies.java16.crmapp.dbconnection.MySqlConnection;
import newbies.java16.crmapp.dto.TaskDto;

public class TaskDao {
	public List<TaskDto> getAll() {
	List<TaskDto> dtos = null;
		String query = "SELECT t.id,t.name,t.description,t.start_date,t.end_date,p.name,t.user_id,t.status_id "
				+ "FROM task t "
				+ "LEFT JOIN project p "
				+ "ON t.project_id = p.id";
		
		try( Connection conn = MySqlConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			dtos = new ArrayList<TaskDto>();
			while(res.next()) {
				TaskDto task = new TaskDto();
				task.setId(res.getInt(1));
				task.setName(res.getString(2));
				task.setDescription(res.getString(3));
				task.setStartDate(res.getDate(4));
				task.setEndDate(res.getDate(5));
				task.setProjectName(res.getString(6));
				task.setUserId(res.getInt(7));
				task.setStatusId(res.getInt(8));
				dtos.add(task);				
			}
			return dtos;
		
		} catch(Exception e) {
			System.out.println("Could not query DB");
		}
		return dtos;
	}
	
	public boolean deleteTask(int id) throws SQLException {
		String query="DELETE FROM task WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			int result = statement.executeUpdate();
			if (result>0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Couldn't delete DB");
		}finally {
			connection.close();
		}
		return false;
	}
	public int findIdByName(String name) {
		String query = "SELECT id from task where name like ?";
		Connection connection = MySqlConnection.getConnection();
		int id=0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
			return id=result.getInt(1);	
			}
		} catch (SQLException e) {
			System.out.println("Couldn't connect to DB");
		}
		return id;
	}
	public boolean update(String start_day, String end_date,int status, int id) throws SQLException {
		String query = "UPDATE task SET start_date = ?, end_date = ?, status_id = ? WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, start_day);
			statement.setString(2, end_date);
			statement.setInt(3,status);
			statement.setInt(4,id);
			statement.executeUpdate();
			int result = statement.executeUpdate();
			if (result>0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Couldn't update DB");
		}finally {
			connection.close();
		}
		return false;
	}
}
