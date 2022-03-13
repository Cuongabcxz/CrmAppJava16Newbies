package newbies.java16.testConnection;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import newbies.java16.crmapp.dao.TaskDao;
import newbies.java16.crmapp.dto.TaskDto;

@TestInstance(Lifecycle.PER_CLASS)
public class TestTask {
	private TaskDao dao;

	@BeforeAll
	public void setup() {
		dao = new TaskDao();
	}

	@Test
	public void findAll() {
		List<TaskDto> dtos = dao.getAll();
		assertTrue(dtos.size() > 0);
	}
}
