package newbies.java16.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.ServletConst;
import newbies.java16.crmapp.util.UrlConst;
@WebServlet(name = ServletConst.AUTH, urlPatterns = {
		UrlConst.LOGIN,
		UrlConst.SIGNUP
})
public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
	}

}
