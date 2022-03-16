package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newbies.java16.crmapp.dao.TaskDao;
import newbies.java16.crmapp.dto.TaskDto;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.UrlConst;
@WebServlet(urlPatterns = {UrlConst.TASKLIST
							,UrlConst.TASKCREATE
							,UrlConst.TASKDELETE
							,UrlConst.TASKUPDATE})
public class TaskServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TaskDao dao;
	@Override
		public void init() throws ServletException {
		dao = new TaskDao();
		}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path = req.getServletPath();
	switch (path) {
	case UrlConst.TASKLIST:
		List<TaskDto> listTask = dao.getAll();
		req.setAttribute("tasks", listTask);
		req.getRequestDispatcher(JspConst.TASKLIST).forward(req, resp);
		break;
	case UrlConst.TASKCREATE:
		req.getRequestDispatcher(JspConst.TASKCREATE).forward(req, resp);
	default:
		break;
	}
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path = req.getServletPath();
	switch (path) {
	case UrlConst.TASKDELETE:
		int id = Integer.parseInt(req.getParameter("taskId")) ;
		int statusId = Integer.parseInt(req.getParameter("taskStatus"));
		System.out.println(id+statusId);
		if (statusId == 1) {
			try {
				dao.deleteTask(id);
			} catch (SQLException | NumberFormatException e) {
			}
		}
		List<TaskDto> listTask = dao.getAll();
		req.setAttribute("tasks", listTask);
		req.getRequestDispatcher(JspConst.TASKLIST).forward(req, resp);
		break;
	case UrlConst.TASKUPDATE:
		String name = req.getParameter("taskName");
		int status = Integer.parseInt(req.getParameter("status"));
		String start_day = req.getParameter("start_day").replace("/", "-");
		String end_day = req.getParameter("end_day").replace("/", "-");
		int idTask = dao.findIdByName(name);
		if (idTask !=0) {
			try {
				dao.update(start_day, end_day, status, idTask);
			} catch (SQLException e) {
			}
		}
		List<TaskDto> listTask1 = dao.getAll();
		req.setAttribute("tasks", listTask1);
		req.getRequestDispatcher(JspConst.TASKLIST).forward(req, resp);
		break;
	default:
		break;
	}
	}
}
