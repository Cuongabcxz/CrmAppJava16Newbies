package newbies.java16.crmapp.filter;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newbies.java16.crmapp.util.UrlConst;

@WebFilter(urlPatterns = UrlConst.GLOBAL)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		if (!(path.startsWith(UrlConst.LOGIN) || path.startsWith(UrlConst.SIGNUP))) {
			Object user = req.getSession().getAttribute("userlogin");
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
			}
		}else {
			chain.doFilter(request, response);
		}
	}
}
