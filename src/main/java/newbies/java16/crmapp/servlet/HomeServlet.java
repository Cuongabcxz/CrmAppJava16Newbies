package newbies.java16.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newbies.java16.crmapp.dto.UserLoginDto;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.ServletConst;
import newbies.java16.crmapp.util.UrlConst;
@WebServlet(name = ServletConst.HOME, urlPatterns = UrlConst.HOMEPAGE)
public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	UserLoginDto dto = (UserLoginDto) req.getSession().getAttribute("userlogin");
	req.setAttribute("dto", dto);
	req.getRequestDispatcher(JspConst.HOMEPAGE).forward(req, resp);
}
}
