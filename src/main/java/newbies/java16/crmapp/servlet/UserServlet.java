package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newbies.java16.crmapp.dao.UserDao;
import newbies.java16.crmapp.dto.UserLoginDto;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = { UrlConst.USERLIST, UrlConst.USERDELETE, UrlConst.USERUPDATE,
		UrlConst.USERCREATE })
public class UserServlet extends HttpServlet {

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
			List<UserLoginDto> listUser = userDao.getAll();
			req.setAttribute("users", listUser);
			req.getRequestDispatcher(JspConst.USERLIST).forward(req, resp);
			break;
		case UrlConst.USERDELETE:
			userDao.delete(req.getParameter("id"));
			req.setAttribute("users", userDao.getAll());
			req.getRequestDispatcher(JspConst.USERLIST).forward(req, resp);
		case UrlConst.USERCREATE:
			req.getRequestDispatcher(JspConst.USERCREATE).forward(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.USERCREATE:
			UserLoginDto user = new UserLoginDto();
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			int role_id = Integer.parseInt(req.getParameter("role_id"));
			user.setEmail(email);
			user.setAddress(address);
			user.setPhone(phone);
			user.setPassword(password);
			user.setRoleId(role_id);
			user.setName(name);
			if(userDao.create(user)) {
				req.setAttribute("message1", "Congratulations ! ");
			}else {
				req.setAttribute("message2", "Email has already been taken ! ");
			}
			req.getRequestDispatcher(JspConst.USERCREATE).forward(req, resp);
			break;
		case UrlConst.USERUPDATE:
			String name1 = req.getParameter("username");
			String email1 = req.getParameter("email");
			String address1 = req.getParameter("address");
			int id1 =Integer.parseInt(req.getParameter("id"));
			String phone1 = req.getParameter("phone");
			int role_id1 = Integer.parseInt(req.getParameter("role_id"));
			userDao.update(id1, name1, email1, address1, phone1, role_id1);
			req.setAttribute("users", userDao.getAll());
			req.getRequestDispatcher(JspConst.USERLIST).forward(req, resp);
			break;
		default:
			break;
		}
	}
}
