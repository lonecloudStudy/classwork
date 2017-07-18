package cn.classwork.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.entity.User;

public class PerssionFilter implements Filter {

	String[] urls = { "member.html", "master.html" };

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (req instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) req;
			String requestURI = request.getRequestURI();
			System.out.println(requestURI);
			// 判断权限
			if (isPerssionUrl(requestURI)) {
				User user = (User) request.getSession().getAttribute("user");
				if (user == null) {
					((HttpServletResponse) response).sendRedirect("login.html");
				}
			}
			chain.doFilter(request, response);
			// requestURI

		}
	}

	private boolean isPerssionUrl(String requestUrl) {
		for (String url : urls) {
			if (requestUrl != null && requestUrl.contains(url)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
