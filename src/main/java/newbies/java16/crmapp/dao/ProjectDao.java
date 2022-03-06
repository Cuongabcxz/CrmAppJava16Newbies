package newbies.java16.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newbies.java16.crmapp.dbconnection.MySqlConnection;
import newbies.java16.crmapp.dto.ProjectDto;
import newbies.java16.crmapp.model.Project;

public class ProjectDao {
	public List<ProjectDto> findAll() throws SQLException {
		Connection connection = MySqlConnection.getConnection();
		String query = "SELECT p.name,p.start_date,p.end_date,user.email FROM project p LEFT JOIN user ON p.owner = user.id";
		List<ProjectDto> listProject = new ArrayList<ProjectDto>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ProjectDto project = new ProjectDto();
				project.setName(result.getString(1));
				project.setStartDate(result.getDate(2));
				project.setEndDate(result.getDate(3));
				project.setNameOfManager(result.getString(4));
				listProject.add(project);
			}

		} catch (SQLException e) {
			System.out.println("Couldn't connect to DB");
		}finally {
			connection.close();
		}
		return listProject;
	}
	public int findIdByName(String name) {
		String query = "SELECT id from project where name like ?";
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
	
	public void update(String start_day, String end_date, int id) throws SQLException {
		String query = "UPDATE project SET start_date = ?, end_date = ? WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, start_day);
			statement.setString(2, end_date);
			statement.setInt(3,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldn't connect to DB");
		}finally {
			connection.close();
		}
	}
	public void createProject(Project project) throws SQLException {
		String query="INSERT INTO project(name,description,start_date,end_date,owner) VALUES(?,?,?,?,?)";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3,project.getStartDate());
			statement.setDate(4,project.getEndDate());
			statement.setInt(5,project.getOwner());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldn't connect to DB");
		}finally {
			connection.close();
		}
	}
}
