package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newbies.java16.crmapp.dao.UserDao;
import newbies.java16.crmapp.dto.UserLoginDto;
import newbies.java16.crmapp.model.Project;
import newbies.java16.crmapp.service.ProjectService;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.UrlConst;

@WebServlet(name = "PROJECT", urlPatterns = { UrlConst.PROJECT, UrlConst.PROJECTUPDATE, UrlConst.PROJECTCREATE,
		UrlConst.PROJECTDELETE })
public class ProjectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectService service;
	private Project project;
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		service = new ProjectService();
		userDao = new UserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.PROJECT:
			List<Project> projects = service.projectDtoToProject();
			req.setAttribute("projects", projects);
			req.getRequestDispatcher(JspConst.PROJECT).forward(req, resp);
			break;
		case UrlConst.PROJECTCREATE:
			List<UserLoginDto> listUsers = userDao.getAll();
			req.setAttribute("listUsers", listUsers);
			req.getRequestDispatcher(JspConst.CREATEPROJECT).forward(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("projectName");
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.PROJECTUPDATE:
			String start_day = req.getParameter("start_day").replace("/", "-");
			String end_day = req.getParameter("end_day").replace("/", "-");
			String email = req.getParameter("email");
			try {
				UserLoginDto dto = userDao.findUserByEmail(email);
				if (dto != null) {
					if (dto.getRoleId() != 3) {
						int id = service.findIdByName(name);
						service.update(start_day, end_day, dto.getId(), id);
					}
				}
			} catch (NullPointerException e) {
			}
			List<Project> projects = service.projectDtoToProject();
			req.setAttribute("projects", projects);
			req.getRequestDispatcher(JspConst.PROJECT).forward(req, resp);
			break;
		case UrlConst.PROJECTCREATE:
			String start_day1 = req.getParameter("start_day").replace("/", "-");
			String end_day1 = req.getParameter("end_day").replace("/", "-");
			String description = req.getParameter("description");
			String owner = req.getParameter("owner");
			project = new Project(name, description, Date.valueOf(start_day1), Date.valueOf(end_day1),
					Integer.parseInt(owner));
			if (project !=null) {
				try {
					service.createProject(project);
				} catch (SQLException e) {
					System.out.println("Fail");
				}
			}
			req.setAttribute("message", "Completed !");
			req.getRequestDispatcher(JspConst.CREATEPROJECT).forward(req, resp);
			break;
		case UrlConst.PROJECTDELETE:
			int id = service.findIdByName(name);
			try {
				service.deleteProject(id);
			} catch (SQLException e) {
			}
			resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT);
			break;
		default:
			break;
		}
	}
}
