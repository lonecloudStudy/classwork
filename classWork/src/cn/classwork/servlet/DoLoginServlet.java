package cn.classwork.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;
import cn.classwork.util.StringUtils;

@WebServlet("/doLogin")
public class DoLoginServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (!StringUtils.isAllNotNull(username, password)) {
			JsonMsgUtils.errorMsg("用户名或者密码为空", resp);
		} else {
			try {
				User user = userService.checkLogin(username, password);
				if (user == null) {
					JsonMsgUtils.errorMsg("该用户不存在或者密码错误", resp);
				} else {
					req.getSession().setAttribute("user", user);
					JsonMsgUtils.successMsg("登录成功", resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
				JsonMsgUtils.errorMsg("系统错误", resp);
			}
		}

	}
}
