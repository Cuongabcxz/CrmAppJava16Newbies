package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	default:
		break;
	}
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path = req.getServletPath();
	switch (path) {
	case UrlConst.TASKDELETE:
		List<TaskDto> listTask = dao.getAll();
		req.setAttribute("tasks", listTask);
		req.getRequestDispatcher(JspConst.TASKLIST).forward(req, resp);
		break;

	default:
		break;
	}
	}
}
