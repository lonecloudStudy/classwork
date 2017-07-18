package cn.classwork.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;

@WebServlet("/register")
public class RegisterServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = coverUser(request);
		try {
			userService.saveUser(user);
			JsonMsgUtils.successMsg("注册成功", response);
		} catch (Exception e) {
			JsonMsgUtils.errorMsg("系统错误", response);
			e.printStackTrace();
		}

	}

	/**
	 * 整合user
	 * 
	 * @Description:
	 * @param request
	 * @return
	 */
	private User coverUser(HttpServletRequest request) {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setIdcard(request.getParameter("idcard"));
		user.setFullname(request.getParameter("fullname"));
		user.setRegisterIp(request.getRemoteAddr());
		user.setRegistertime(new Date());
		user.setLogintime(null);
		return user;
	}
}
