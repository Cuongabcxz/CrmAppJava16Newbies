package newbies.java16.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import newbies.java16.crmapp.dbconnection.MySqlConnection;
import newbies.java16.crmapp.dto.TaskDto;
import newbies.java16.crmapp.dto.UserLoginDto;

public class TaskDao {
	public List<TaskDto> getAll() {
	List<TaskDto> dtos = null;
		String query = "SELECT * FROM task";
		
		try( Connection conn = MySqlConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			dtos = new ArrayList<TaskDto>();
			while(res.next()) {
				TaskDto task = new TaskDto();
				task.setName(res.getString(2));
				task.setDescription(res.getString(3));
				task.setStartDate(res.getDate(4));
				task.setEndDate(res.getDate(5));
				task.setProjectId(res.getInt(6));
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
}
