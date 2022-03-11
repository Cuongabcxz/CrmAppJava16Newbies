package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newbies.java16.crmapp.dao.UserDao;
import newbies.java16.crmapp.dto.UserLoginDto;
import newbies.java16.crmapp.model.User;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {UrlConst.USERLIST, UrlConst.USERDELETE, UrlConst.USERUPDATE} )
public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = null;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.USERLIST:
			req.setAttribute("users", userDao.getAll());
			req.getRequestDispatcher(JspConst.USERLIST).forward(req, resp);
			break;
		case UrlConst.USERDELETE:
			userDao.delete(req.getParameter("id"));
			req.setAttribute("users", userDao.getAll());
			req.getRequestDispatcher(JspConst.USERLIST).forward(req, resp);
		default:
			break;
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserLoginDto user = new UserLoginDto();
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		Integer role_id = Integer.parseInt(req.getParameter("role_id"));
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);		
		user.setPhone(phone);
		user.setId(id);
		user.setPassword(password);
		user.setRoleId(role_id);
		if(req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
			userDao.update(id, name, email, address, phone, role_id);
			
		} else {
			userDao.insert(user);
			
		}
		req.setAttribute("users", userDao.getAll());
		req.getRequestDispatcher(JspConst.USERLIST).forward(req, resp);

	}
	

		
}
