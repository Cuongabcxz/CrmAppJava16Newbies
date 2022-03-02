package newbies.java16.crmapp.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newbies.java16.crmapp.dto.UserLoginDto;
import newbies.java16.crmapp.service.AuthService;
import newbies.java16.crmapp.util.JspConst;
import newbies.java16.crmapp.util.ServletConst;
import newbies.java16.crmapp.util.UrlConst;

@WebServlet(name = ServletConst.AUTH, urlPatterns = { UrlConst.LOGIN, UrlConst.SIGNUP })
public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuthService service;
	private UserLoginDto dto;

	@Override
	public void init() throws ServletException {
		service = new AuthService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.LOGIN:
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				Optional<Cookie> emailCookie = Arrays.asList(cookies).stream().filter(t -> t.getName().equals("email"))
						.findFirst();
				if (emailCookie.isPresent()) {
					req.setAttribute("email", emailCookie.get().getValue());
					req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
				} else {
					req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
				}
			}
			break;
		case UrlConst.SIGNUP:
			req.getRequestDispatcher(JspConst.SIGNUP).forward(req, resp);
			break;
		case UrlConst.LOGOUT:
			Object userLogout = req.getSession().getAttribute("userlogin");
			if (userLogout != null) {
				HttpSession session = req.getSession();
				session.removeAttribute("userlogin");
				resp.sendRedirect(req.getContextPath()+UrlConst.LOGIN);
			}
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		String name = req.getParameter("name");
		switch (path) {
		case UrlConst.LOGIN:
			if (remember !=null) {
				Cookie cookie = new Cookie("email", email);
				cookie.setMaxAge(60);
				resp.addCookie(cookie);
			}
			if (service.login(email, password)) {
				dto = new UserLoginDto(email, password);
				HttpSession session = req.getSession();
				session.setAttribute("userlogin", dto);
				resp.sendRedirect(req.getContextPath() + UrlConst.HOMEPAGE);
			} else {
				req.setAttribute("message", "Email or passoword is incorrect");
				req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
			}
			break;
		case UrlConst.SIGNUP:
			if (service.sigup(email, password, name)) {
				resp.sendRedirect(req.getContextPath()+UrlConst.LOGIN);
			}else {
				req.setAttribute("message", "Email has already been taken");
				req.getRequestDispatcher(JspConst.SIGNUP).forward(req, resp);
			}
			
			break;
		default:
			break;
		}
	}
}
