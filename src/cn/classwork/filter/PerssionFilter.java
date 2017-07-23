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
/**
 * 权限管理用于拦截用户是否登录，如果没有登录则跳转到登录页面
 * @Title: PerssionFilter.java
 * @Package cn.classwork.filter
 * @version V1.0
 */
public class PerssionFilter implements Filter {

	String[] urls = { "member.html", "master.html" };//拦截url

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (req instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) req;
			String requestURI = request.getRequestURI();
			System.out.println(requestURI);
			// 判断权限
			if (isPerssionUrl(requestURI)) {
				User user = (User) request.getSession().getAttribute("user");//获取session中的用户
				if (user == null) {
					((HttpServletResponse) response).sendRedirect("login.html");//没登录了就将页面跳转到登录页面
				}
			}
			chain.doFilter(request, response);
		}
	}
	/**
	 * 判断url是不是需要登录后才能操作的url
	 * @Description: 
	 * @param requestUrl
	 * @return
	 */
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
