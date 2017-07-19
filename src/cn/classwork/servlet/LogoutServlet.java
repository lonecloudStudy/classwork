package cn.classwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
/**
 * 用户登出
 * @Title: LogoutServlet.java
 * @Package cn.classwork.servlet
 * @date 2017年7月18日 下午2:52:46
 * @version V1.0
 */
@WebServlet("/logout")
public class LogoutServlet extends BaseServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//清除session中的user变量
		req.getSession().setAttribute("user", null);
		//将页面重定向到登录页面
		resp.sendRedirect("index.html");
	}
}
