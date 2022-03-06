package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newbies.java16.crmapp.model.Project;
import newbies.java16.crmapp.model.User;
import newbies.java16.crmapp.service.ProjectService;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.UrlConst;

@WebServlet(name = "PROJECT", urlPatterns = { UrlConst.PROJECT, UrlConst.UPDATEPROJECT, UrlConst.CREATEPROJECT })
public class ProjectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectService service;
	private Project project;

	@Override
	public void init() throws ServletException {
		service = new ProjectService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.PROJECT:
			User user = (User) req.getSession().getAttribute("userlogin");
			req.setAttribute("userlogin", user);
			List<Project> projects = service.projectDtoToProject();
			HttpSession session = req.getSession();
			session.setAttribute("projects", projects);
			req.getRequestDispatcher(JspConst.PROJECT).forward(req, resp);
			break;
		case UrlConst.CREATEPROJECT:
			req.getRequestDispatcher(JspConst.CREATEPROJECT).forward(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name;
		String start_day;
		String end_day;
		String description;
		String owner;
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.UPDATEPROJECT:
			name = req.getParameter("projectName");
			start_day = req.getParameter("start_day");
			end_day = req.getParameter("end_day");
			int id = service.findIdByName(name);
			service.update(start_day, end_day, id);
			List<Project> projects = service.projectDtoToProject();
			req.setAttribute("projects", projects);
			req.getRequestDispatcher(JspConst.PROJECT).forward(req, resp);
			break;
		case UrlConst.CREATEPROJECT:
			name = req.getParameter("projectName");
			start_day = req.getParameter("start_day").replace("/", "-");
			end_day = req.getParameter("end_day").replace("/","-");
			description = req.getParameter("description");
			owner = req.getParameter("owner");
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				project = new Project(name, description,Date.valueOf(start_day), Date.valueOf(end_day), Integer.parseInt(owner));
			try {
				service.createProject(project);
			} catch (SQLException e) {
				System.out.println("Fail");
			}
				req.setAttribute("message", "Completed !");
				req.getRequestDispatcher(JspConst.CREATEPROJECT).forward(req, resp);
			break;
		default:
			break;
		}
	}
}
