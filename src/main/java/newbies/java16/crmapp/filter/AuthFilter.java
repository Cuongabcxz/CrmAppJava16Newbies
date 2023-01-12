package newbies.java16.crmapp.filter;

import newbies.java16.crmapp.util.UrlConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = UrlConst.GLOBAL)
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		if (!path.startsWith(UrlConst.LOGIN)) {
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

	@Override
	public void destroy() {

	}
}
