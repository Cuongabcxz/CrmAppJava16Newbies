package newbies.java16.testConnection;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import newbies.java16.crmapp.dao.ProjectDao;
import newbies.java16.crmapp.dto.ProjectDto;
import newbies.java16.crmapp.model.Project;

@TestInstance(Lifecycle.PER_CLASS)
public class TestProject {
	private ProjectDao dao;

	@BeforeAll
	public void setup() {
		dao = new ProjectDao();
	}

//	@Test
//	public void findAll() throws SQLException {
//		List<ProjectDto> list = dao.findAll();
//		assertTrue(list.size() > 0);
//	}
//	@Test
//	public void create() throws ParseException {
//		String date ="2020/10/19";
//		String text = date.replace("/", "-");
//		Date date2 = Date.valueOf(text);
//		System.out.println(date2);
//		assertTrue(date2!=null);
//	}
	@Test
	public void update() throws SQLException {
		String date ="2020-10-20";
		String date1 ="2020-10-22";
		assertTrue(dao.update(date, date1, 6, 3));
	}
}
